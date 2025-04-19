package cryptography;


import cryptography.entity.Result;
import cryptography.resources.Resource;

public class ConsoleRunner {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        String[] arguments = consoleInput.requestArguments();
        if (arguments[0].equals("EXIT")) {
            System.out.println(Resource.getSecretPhrase());
            return;
        }
        Application application = new Application();
        Result result = application.run(arguments);
        System.out.println(result);
    }
}