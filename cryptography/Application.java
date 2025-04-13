package cryptography;

import cryptography.controllers.MainController;
import cryptography.entity.Result;
import cryptography.exeptions.AppException;

import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] arguments) {
        if (arguments.length > 0) {
            String action = arguments[0];
            String[] otherParameters = Arrays.copyOfRange(arguments, 1, arguments.length);
            return mainController.doAction(action, otherParameters);
        } else {
            throw new AppException("not arguments");
        }
    }
}
