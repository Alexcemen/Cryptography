package cryptography.actions;

import cryptography.exeptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    WHITESPACE(new Whitespacer()),
    BRUTE_FORCE(new BruteForcer()),
    CLEAN(new Cleaner());
    
    private final Action action;

    Actions(Action action) {
        this.action = action;
    }
    
    public static Action find(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + actionName, e);
        }
    }
}
