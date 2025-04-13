package cryptography.actions;

import cryptography.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
