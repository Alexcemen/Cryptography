package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;

public class BruteForcer extends CaesarCipher implements Action {
    @Override
    public Result execute(String[] parameters) {
        return new Result("Расшифровка Brute Force прошла успешно", ResultCode.OK);
    }
}
