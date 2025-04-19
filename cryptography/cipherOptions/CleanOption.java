package cryptography.cipherOptions;

import cryptography.resources.FileNames;

import java.nio.file.Files;

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
        String[] arguments = {"CLEAN", FileNames.getDefaultOutputFileNameForEncryption(),
                FileNames.getDefaultOutputFileNameForDecryption(),
        FileNames.getDefaultOutputFileNameForBruteForce()};
        return arguments;
    }

}
