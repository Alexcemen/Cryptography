package cryptography.cipherOptions;

import cryptography.Validator;

import java.util.Scanner;

public abstract class CipherOption {
    Validator validator = new Validator();
    Scanner scanner = new Scanner(System.in);

    public abstract String getInputFileName();

    public abstract String getOutputFileName();

    public abstract String[] requestArguments();

}
