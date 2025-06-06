package cryptography.resources;

public class Resource {


    private static final String DEFAULT_INPUT_FILE_NAME_FOR_ENCRYPTION = "cryptography/text/war_and_peace.ru.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_ENCRYPTION = "cryptography/text/outputFileNameForEncryption.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_DECRYPTION = "cryptography/text/outputFileNameForDecryption.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_WHITESPACE = "cryptography/text/outputFileNameForWhitespace.txt";
    private static final String DEFAULT_OUTPUT_FILE_NAME_FOR_BRUTE_FORCE = "cryptography/text/outputFileNameForBruteForce.txt";
    private static final String GLOSSARY_FILE_NAME = "cryptography/resources/glossary.txt";
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

    public static String getDefaultInputFileNameForBruteForce() {
        return getDefaultOutputFileNameForEncryption();
    }

    public static String getDefaultOutputFileNameForBruteForce() {
        return DEFAULT_OUTPUT_FILE_NAME_FOR_BRUTE_FORCE;
    }

    public static String getGlossaryFileName() {
        return GLOSSARY_FILE_NAME;
    }
}
