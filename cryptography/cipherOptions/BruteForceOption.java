package cryptography.cipherOptions;

import cryptography.resources.fileNames;

public class BruteForceOption extends CipherOption {

    @Override
    public String[] requestArguments() {
        String inputFileNameForBruteForce = getInputFileName();
        String outputFileNameForBruteForce = getOutputFileName();
        return new String[] {"BRUTE_FORCE", inputFileNameForBruteForce, outputFileNameForBruteForce};
    }

    @Override
    public String getInputFileName() {
        while (true) {
            System.out.println("Напишите путь к зашифрованному файлу, который нужно взломать.");
            System.out.println("Или нажмите на \"ENTER\", и мы предоставим свой файл");
            String inputFileNameForBruteForce = scanner.nextLine();
            if (inputFileNameForBruteForce.isEmpty()) {
                return fileNames.getDefaultInputFileNameForBruteForce();
            }
            if (validator.isFileExists(inputFileNameForBruteForce)) {
                return inputFileNameForBruteForce;
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
            String outputFileNameForBruteForce = scanner.nextLine();
            if (outputFileNameForBruteForce.isEmpty()) {
                return fileNames.getDefaultOutputFileNameForBruteForce();
            }
            if (validator.isFileExists(outputFileNameForBruteForce)) {
                return outputFileNameForBruteForce;
            } else {
                System.out.println("Ошибка! Такого файла не существует\n");
            }
        }
    }
}
