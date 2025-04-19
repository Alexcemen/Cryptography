package cryptography.resources;

public class FileNames {


    private static final String DEFAULT_INPUT_FILE_NAME_FOR_ENCRYPTION = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/war_and_peace.ru.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_ENCRYPTION = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/outputFileNameForEncryption.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_DECRYPTION = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/outputFileNameForDecryption.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_BRUTE_FORCE = "/Users/alexcemen/IdeaProjects/Cryptographyy/cryptography/text/outputFileNameForBruteForce.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_STATISTICAL_ANALYZER = "";

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

    public static String getDefaultInputFileNameForBruteForce() {
        return getDefaultOutputFileNameForEncryption();
    }

    public static String getDefaultOutputFileNameForBruteForce() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_BRUTE_FORCE;
    }

    public static String getDefaultInputFileNameForStatisticalAnalyzer() {
        return getDefaultOutputFileNameForEncryption();
    }

    public static String getDefaultOutputFileNameForStatisticalAnalyzer() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_STATISTICAL_ANALYZER;
    }
}
