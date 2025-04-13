package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;

public class Encoder extends CaesarCipher implements Action {

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        processFile(inputFileName, outputFileName, line -> encrypt(line, key));
        return new Result("Шифрование прошло успешно", ResultCode.OK);
    }
}
