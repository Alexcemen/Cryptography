package cryptography;


import cryptography.cipherOptions.CipherOption;
import cryptography.cipherOptions.CipherOptions;

import java.util.Scanner;

public class ConsoleInput {

    public String[] requestArguments() {
        showCipherOptions();
        CipherOption cipherOption = CipherOptions.find(getSelectedCipherOption());
        return cipherOption.requestArguments();
    }

    private static void showCipherOptions() {
        System.out.println("Перед вами шифровальщик Цезаря.");
        System.out.println("С его помощью вы можете: ");
        System.out.println("- Зашифровать ваш файл.");
        System.out.println("- Расшифровать файл (если у вас есть ключ).");
        System.out.println("- Если вы не знаете ключ - можем попытаться взломать этот файл методом нахождения пробела.");
        System.out.println("- Или можем попытаться взломать с помощью Brute Force");
        System.out.println();
        System.out.println("Что вы хотите:");
        System.out.println("1 - зашифровать свой файл");
        System.out.println("2 - расшифровать файл (у меня есть ключ).");
        System.out.println("3 - взломать файл методом Whitespace");
        System.out.println("4 - взломать файл с помощью Brute Force");
        System.out.println("5 - очистить содержимое дефолтных файлов");
        System.out.println("6 - выйти из программы");
        System.out.println();
    }

    private String getSelectedCipherOption() {
        return switch (getNumberSelectedCipherOption()) {
            case 1 -> {
                System.out.println("Вы выбрали \"зашифровать файл\"");
                yield "ENCODE";
            }
            case 2 -> {
                System.out.println("Вы выбрали \"расшифровать файл\"");
                yield "DECODE";
            }
            case 3 -> {
                System.out.println("Вы выбрали \"взломать файл методом Whitespace\"");
                System.out.println("Этот подразумевает, что самым часто встречающимся символом в зашифрованом тексте является пробел");
                yield "WHITESPACE";
            }
            case 4 -> {
                System.out.println("Вы выбрали \"взломать файл методом Brute Force\"");
                yield "BRUTE_FORCE";
            }
            case 5 -> {
                System.out.println("Вы выбрали \"очистить содержимое дефолтных файлов\"");
                yield "CLEAN";
            }
            case 6 -> {
                System.out.println("Вы выбрали \"выйти из программы\"");
                yield "EXIT";
            }
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    private int getNumberSelectedCipherOption() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите цифру от 1 до 6: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.matches("[1-6]")) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("Ошибка! Введите ЦИФРУ от 1 до 6.");
            }
        }
    }
}
