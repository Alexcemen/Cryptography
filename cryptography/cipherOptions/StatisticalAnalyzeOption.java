package cryptography.cipherOptions;

public class StatisticalAnalyzeOption extends CipherOption {
    @Override
    public String[] requestArguments() {
        return new String[] {"STATISTICAL_ANALYZER"};
    }

    @Override
    public String getInputFileName() {
        return "";
    }

    @Override
    public String getOutputFileName() {
        return "";
    }
}
