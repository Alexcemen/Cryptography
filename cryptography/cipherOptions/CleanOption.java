package cryptography.cipherOptions;

import cryptography.resources.Resource;

public class CleanOption extends CipherOption {
    @Override
    public String getInputFileName() {
        return "";
    }

    @Override
    public String getOutputFileName() {
        return "";
    }

    @Override
    public String[] requestArguments() {
        return new String[]{"CLEAN", Resource.getDefaultOutputFileNameForEncryption(),
                Resource.getDefaultOutputFileNameForDecryption(),
        Resource.getDefaultOutputFileNameForWhitespace()};
    }
}
