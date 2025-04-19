package cryptography;

import cryptography.resources.Alphabet;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    private final Alphabet alphabet = new Alphabet();

    //проверяет, входит ли key в диапазон от 0 до alphabet.getSize()-1
    public boolean isValidKey(int key) {
        boolean isValid = key >= 0 && key < alphabet.getSize()-1;
        System.out.printf("Ключ %d %s условия валидации.%n",
                key, isValid ? "подходит под" : "не подходит под");
        return isValid;
    }

    //проверяет, существует ли файл
    public boolean isFileExists(String filePath) {
        Path path = Path.of(filePath);
        boolean isFileExists = (Files.exists(path) && Files.isRegularFile(path));
        if (isFileExists) {
            System.out.println("Файл существует и является обычным файлом.");
        } else {
            System.out.println("Файл не найден или это не обычный файл.");
        }
        return isFileExists;
    }
}
