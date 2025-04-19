package cryptography.cipherOptions;

import cryptography.resources.Resource;

public class DecodeOption extends CipherOption {
    @Override
    public String[] requestArguments() {
        String inputFileNameForDecryption = getInputFileName();
        String outputFileNameForDecryption = getOutputFileName();
        String cipherKey = getCipherKey();
        return new String[] {"DECODE", inputFileNameForDecryption, outputFileNameForDecryption, cipherKey};
    }

    @Override
    public String getInputFileName() {
        while (true) {
            System.out.println("Напишите путь к файлу, который нужно расшифровать.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String inputFileNameForDecrypted = scanner.nextLine();
            if (inputFileNameForDecrypted.isEmpty()) {
                return Resource.getDefaultInputFileNameForDecryption();
            }
            if (validator.isFileExists(inputFileNameForDecrypted)) {
                return inputFileNameForDecrypted;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }

    @Override
    public String getOutputFileName() {
        while (true) {
            System.out.println("Напишите путь к файлу, в который нужно записать расшифрованный текст.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String outputFileNameForDecryption = scanner.nextLine();
            if (outputFileNameForDecryption.isEmpty()) {
                return Resource.getDefaultOutputFileNameForDecryption();
            }
            if (validator.isFileExists(outputFileNameForDecryption)) {
                return outputFileNameForDecryption;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }

    private String getCipherKey() {
        while (true) {
            System.out.println("Введите ключ.");
            String cipherKey = scanner.nextLine().trim();
            try {
                int key = Integer.parseInt(cipherKey);
                if (validator.isValidKey(key)) {
                    return cipherKey;
                } else {
                    System.out.println("Ошибка! Введенный ключ не соответствует допустимому диапазону.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Необходимо ввести число.");
            }
        }
    }
}
