package cryptography.cipherOptions;

import cryptography.resources.Resource;

public class WhitespaceOption extends CipherOption {

    @Override
    public String[] requestArguments() {
        String inputFileNameForWhitespace = getInputFileName();
        String outputFileNameForWhitespace = getOutputFileName();
        return new String[] {"WHITESPACE", inputFileNameForWhitespace, outputFileNameForWhitespace};
    }

    @Override
    public String getInputFileName() {
        while (true) {
            System.out.println("Напишите путь к зашифрованному файлу, который нужно взломать.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String inputFileNameForWhitespace = scanner.nextLine();
            if (inputFileNameForWhitespace.isEmpty()) {
                return Resource.getDefaultInputFileNameForWhitespace();
            }
            if (validator.isFileExists(inputFileNameForWhitespace)) {
                return inputFileNameForWhitespace;
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
            String outputFileNameForWhitespace = scanner.nextLine();
            if (outputFileNameForWhitespace.isEmpty()) {
                return Resource.getDefaultOutputFileNameForWhitespace();
            }
            if (validator.isFileExists(outputFileNameForWhitespace)) {
                return outputFileNameForWhitespace;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }
}
