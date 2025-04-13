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
        System.out.println("- Если вы не знаете ключ - можем попытаться взломать этот файл методом brute force.");
        System.out.println("- Или можем попытаться взломать с помощью статистического анализатора");
        System.out.println();
        System.out.println("Что вы хотите:");
        System.out.println("1 - зашифровать свой файл");
        System.out.println("2 - расшифровать файл (у меня есть ключ).");
        System.out.println("3 - взломать файл методом brute force");
        System.out.println("4 - взломать файл с помощью статистического анализатора");
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
                System.out.println("Вы выбрали \"взломать файл методом brute force\"");
                yield "BRUTE_FORCE";
            }
            case 4 -> {
                System.out.println("Вы выбрали \"взломать файл методом statistical analyzer\"");
                System.out.println("Сори, но я хз как это сделать");
                yield "STATISTICAL_ANALYZER";
            }
            //IDEA не дает убрать default. Хотя я еще в методе getNumberSelectedCipherOption() проверил,
            //что не может быть другого значения, кроме как от 1 до 4
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    private int getNumberSelectedCipherOption() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите цифру от 1 до 4: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.matches("[1-4]")) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("Ошибка! Введите ЦИФРУ от 1 до 4.");
            }
        }
    }
}
