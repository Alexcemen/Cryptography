package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;

public class StatisticalAnalyzer extends CaesarCipher implements Action {
    @Override
    public Result execute(String[] parameters) {
        return new Result("Выбери ченить другое", ResultCode.ERROR);
    }
}
