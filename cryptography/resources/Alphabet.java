package cryptography.resources;

import cryptography.exeptions.CaesarAlphabetException;

import java.util.*;

public class Alphabet {

    private static final Character[] RU_ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ë', 'Ж', 'З', 'И', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф',
            'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
    };

    private static final Character[] EN_ALPHABET = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final Character[] SYMBOLS_ALPHABET = {
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ' ', ',', '.', '\'', '!', ':', ';', '(', ')', '<',
            '>', '@', '$', '%', '&', '?', '"', '#', '^', '*',
            '-', '_', '+', '=', '{', '}', '[', ']', '|', '\\',
            '`', '~', '–', '«', '»', '…', '„', '“', '\n', '—'
    };

    private final List<Character> alphabet;

    private final Map<Character, Integer> IndexesByChar;

    public Alphabet() {
        List<Character> temporaryAlphabet = new ArrayList<>();

        temporaryAlphabet.addAll(Arrays.asList(RU_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(EN_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(SYMBOLS_ALPHABET));

        alphabet = List.copyOf(temporaryAlphabet);

        IndexesByChar = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            IndexesByChar.put(alphabet.get(i), i);
        }
    }

    public Character getCharByIndex(int index) {
        if (index < 0 || index > alphabet.size()) {
            throw new CaesarAlphabetException("Invalid index. Index: " + index + ". Valid is from 0 to " + alphabet.size());
        }

        return alphabet.get(index);
    }

    public int getIndexByChar(Character character) {
        if (!IndexesByChar.containsKey(character)) {
            throw new CaesarAlphabetException("Invalid character. Char: " + character + ". ");
        }
        return IndexesByChar.get(character);
    }

    public int getSize() {
        return alphabet.size();
    }

    public boolean checkCharInAlphabet(char ch) {
        return IndexesByChar.containsKey(ch);
    }
}
