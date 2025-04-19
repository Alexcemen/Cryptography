package cryptography.resources;

public class Resource {


    private static final String DEFAULT_INPUT_FILE_NAME_FOR_ENCRYPTION = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/war_and_peace.ru.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_ENCRYPTION = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/outputFileNameForEncryption.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_DECRYPTION = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/outputFileNameForDecryption.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_WHITESPACE = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/outputFileNameForWhitespace.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_STATISTICAL_ANALYZER = "";
    private static final String SECRET_PHRASE = "НУ И ПОЖАЛУЙСТА!!! НЕ ОЧЕНЬ-ТО И ХОТЕЛОСЬ!!!";

    public static String getDefaultInputFileNameForEncryption() {
        return DEFAULT_INPUT_FILE_NAME_FOR_ENCRYPTION;
    }

    public static String getDefaultOutputFileNameForEncryption() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_ENCRYPTION;
    }

    public static String getDefaultInputFileNameForDecryption() {
        return getDefaultOutputFileNameForEncryption();
    }

    public static String getDefaultOutputFileNameForDecryption() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_DECRYPTION;
    }

    public static String getDefaultInputFileNameForWhitespace() {
        return getDefaultOutputFileNameForEncryption();
    }

    public static String getDefaultOutputFileNameForWhitespace() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_WHITESPACE;
    }

    public static String getSecretPhrase() {
        return SECRET_PHRASE;
    }

    public static String getDefaultInputFileNameForStatisticalAnalyzer() {
        return getDefaultOutputFileNameForEncryption();
    }

    public static String getDefaultOutputFileNameForStatisticalAnalyzer() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_STATISTICAL_ANALYZER;
    }
}
