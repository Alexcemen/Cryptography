package cryptography.cipherOptions;

import cryptography.exeptions.AppException;

public enum CipherOptions {
    ENCODE(new EncodeOption()),
    DECODE(new DecodeOption()),
    WHITESPACE(new WhitespaceOption()),
    BRUTE_FORCE(new BruteForceOption()),
    CLEAN(new CleanOption()),
    EXIT(new Exit());

    private final CipherOption cipherOption;

    CipherOptions(CipherOption abstractOption) {
        this.cipherOption = abstractOption;
    }

    public static CipherOption find(String cipherOption) {
        try {
            CipherOptions value = CipherOptions.valueOf(cipherOption.toUpperCase());
            return value.cipherOption;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + cipherOption, e);
        }
    }
}
