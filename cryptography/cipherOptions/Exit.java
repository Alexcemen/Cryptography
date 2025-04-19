package cryptography.cipherOptions;

public class Exit extends CipherOption {
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
        return new String[]{"EXIT"};
    }
}
