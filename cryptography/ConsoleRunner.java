package cryptography;


import cryptography.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        String[] arguments = consoleInput.requestArguments();
        Application application = new Application();
        Result result = application.run(arguments);
        System.out.println(result);
    }
}