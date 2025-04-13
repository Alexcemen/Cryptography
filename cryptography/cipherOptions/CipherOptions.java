package cryptography.cipherOptions;

import cryptography.exeptions.AppException;

public enum CipherOptions {
    ENCODE(new EncodeOption()),
    DECODE(new DecodeOption()),
    BRUTE_FORCE(new BruteForceOption()),
    STATISTICAL_ANALYZER(new StatisticalAnalyzeOption());

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
