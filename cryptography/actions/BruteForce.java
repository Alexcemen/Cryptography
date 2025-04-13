package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class BruteForce extends CaesarCipher implements Action {

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        String encryptedText = readFile(inputFileName);
        int key = findKey(encryptedText);
        String decryptedText = decrypt(encryptedText, key);
        writeFile(decryptedText, outputFileName);
        return new Result("brute force прошел успешно", ResultCode.OK);
    }

    public String readFile(String inputFileName) {
        Path path = Path.of(inputFileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + inputFileName, e);
        }
        removeEndingNewline(stringBuilder);
        return stringBuilder.toString();
    }


    public static void removeEndingNewline(StringBuilder stringBuilder) {
        if (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) == '\n') {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

    private static int findKey(String text) {
        char mostFrequentCharInText = findMostFrequentChar(text);
        int positionSpaceCharInAlphabet = alphabet.getIndexByChar(' ');
        int positionMostFrequentCharInAlphabet = alphabet.getIndexByChar(mostFrequentCharInText);
        if (positionSpaceCharInAlphabet < 0 || positionMostFrequentCharInAlphabet < 0) {
            throw new IllegalArgumentException("Ошибка: в алфавите отсутствует пробел или частый символ не найден.");
        }
        return Math.floorMod(positionMostFrequentCharInAlphabet - positionSpaceCharInAlphabet, alphabet.getSize());
    }

    private static char findMostFrequentChar(String text) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        char mostFrequentChar = text.charAt(0);
        int maxCount = 0;
        for (char ch : text.toCharArray()) {
            if (!alphabet.checkCharInAlphabet(ch)) {
                continue;
            }
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            if (charCountMap.get(ch) > maxCount) {
                maxCount = charCountMap.get(ch);
                mostFrequentChar = ch;
            }
        }
        return mostFrequentChar;
    }

    public void writeFile(String content, String filePath) {
        Path path = Path.of(filePath);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла: " + filePath, e);
        }
    }
}
