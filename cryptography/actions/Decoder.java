package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;

public class Decoder extends CaesarCipher implements Action {

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        processFile(inputFileName, outputFileName, line -> decrypt(line, key));
        return new Result("Расшифровка прошла успешно", ResultCode.OK);
    }
}
