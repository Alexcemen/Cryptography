package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Делаем гипотезу, что самым частым символом в зашифрованном тексте является пробел.
Пытаемся расшифровать файл.
 */

public class Whitespacer extends CaesarCipher implements Action {
    static int[] arrayFrequencyChar = new int[alphabet.getSize()];

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        int key = getKey(inputFileName);
        Decoder decoder = new Decoder();
        String[] parametersForDecoder = {inputFileName, outputFileName, String.valueOf(key)};
        decoder.execute(parametersForDecoder);
        return new Result("whitespace прошел успешно", ResultCode.OK);
    }

    private int getKey(String inputFileName) {
        fillArrayFrequencyChar(inputFileName);
        char mostFrequentCharInArrayFrequencyChar = findMostFrequentCharInArrayFrequencyChar();
        return findKey(mostFrequentCharInArrayFrequencyChar);
    }

    private int findKey(char mostFrequentCharInArrayFrequencyChar) {
        int positionSpaceCharInAlphabet = alphabet.getIndexByChar(' ');
        int positionMostFrequentCharInAlphabet = alphabet.getIndexByChar(mostFrequentCharInArrayFrequencyChar);
        if (positionSpaceCharInAlphabet < 0 || positionMostFrequentCharInAlphabet < 0) {
            throw new IllegalArgumentException("Ошибка: в алфавите отсутствует пробел или частый символ не найден.");
        }
        return Math.floorMod(positionMostFrequentCharInAlphabet - positionSpaceCharInAlphabet, alphabet.getSize());
    }

    private void fillArrayFrequencyChar(String inputFileName) {
        Path path = Path.of(inputFileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                calculateFrequencyOfEachCharacterInLine(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + inputFileName, e);
        }
    }

    private void calculateFrequencyOfEachCharacterInLine(String line) {
        for (char ch : line.toCharArray()) {
            if (!alphabet.checkCharInAlphabet(ch)) {
                continue;
            }
            int indexByCharInAlphabet = alphabet.getIndexByChar(ch);
            arrayFrequencyChar[indexByCharInAlphabet]++;
        }
    }

    private static char findMostFrequentCharInArrayFrequencyChar() {
        int index = 0;
        for (int i = 0; i < arrayFrequencyChar.length; i++) {
            if (arrayFrequencyChar[i] > arrayFrequencyChar[index]) {
                index = i;
            }
        }
        return alphabet.getCharByIndex(index);
    }
}
