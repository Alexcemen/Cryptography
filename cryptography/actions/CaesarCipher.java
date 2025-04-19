package cryptography.actions;

import cryptography.exeptions.FileProcessingException;
import cryptography.resources.Alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Function;

public abstract class CaesarCipher {
    protected static final StandardOpenOption[] FILE_WRITE_OPTIONS = { StandardOpenOption.CREATE, StandardOpenOption.APPEND};

    protected static final Alphabet alphabet = new Alphabet();

    //самый главный метод
    //в параметрах получаю inputFileName, outputFileName и !!!метод!!!
    protected void processFile(String inputFileName, String outputFileName, Function<String, String> lineProcessor) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputFileName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {     //Сначала считываю с исходного файла строку
                String processedLine = lineProcessor.apply(line);    //Эту строку шифрую или расшифровываю, в зависимости от третьего параметра
                appendToFile(outputFileName, processedLine + System.lineSeparator());   //и сразу же записываю в оутпут файл
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + inputFileName, e);
        }
    }

    protected String encrypt(String line, int key) {
        return process(line, key);
    }

    protected String decrypt(String line, int key) {
        return process(line, -key);
    }

    private String process(String line, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char originalChar = line.charAt(i);
            if (!alphabet.checkCharInAlphabet(originalChar)) {
                continue;
            }
            int originalIndexByChar = alphabet.getIndexByChar(originalChar);
            int newIndexByChar = (alphabet.getSize() + (originalIndexByChar + key)) % alphabet.getSize();

            result.append(alphabet.getCharByIndex(newIndexByChar));
        }
        return result.toString();
    }

    private void appendToFile(String fileName, String content) {
        try {
            Path filePath = Path.of(fileName);
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        } catch (IOException e) {
            throw new FileProcessingException(e.getMessage());
        }
    }
}
