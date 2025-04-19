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

    protected void processFile(String inputFileName, String outputFileName, Function<String, String> lineProcessor) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputFileName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String processedLine = lineProcessor.apply(line);
                appendToFile(outputFileName, processedLine + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + inputFileName, e);
        }
    }

    public String encrypt(String originalText, int key) {
        return process(originalText, key);
    }

    public String decrypt(String originalText, int key) {
        return process(originalText, -key);
    }

    private String process(String originalText, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalText.length(); i++) {
            char originalChar = originalText.charAt(i);
            if (!alphabet.checkCharInAlphabet(originalChar)) {
                continue;
            }
            int originalIndexByChar = alphabet.getIndexByChar(originalChar);
            int newIndexByChar = (alphabet.getSize() + (originalIndexByChar + key)) % alphabet.getSize();

            result.append(alphabet.getCharByIndex(newIndexByChar));
        }
        return result.toString();
    }

    protected void appendToFile(String fileName, String content) {
        try {
            Path filePath = Path.of(fileName);
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        } catch (IOException e) {
            throw new FileProcessingException(e.getMessage());
        }
    }
}
