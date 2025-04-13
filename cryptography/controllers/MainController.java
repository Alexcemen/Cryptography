package cryptography.controllers;

import cryptography.actions.Action;
import cryptography.actions.Actions;
import cryptography.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }

}
