package cryptography.actions;

import cryptography.entity.Result;
import cryptography.entity.ResultCode;
import cryptography.exeptions.FileProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Cleaner implements Action {
    @Override
    public Result execute(String[] parameters) {
        String outputFileNameForEncryption = parameters[0];
        Path path1 = Path.of(outputFileNameForEncryption);
        String outputFileNameForDecryption = parameters[1];
        Path path2 = Path.of(outputFileNameForDecryption);
        String outputFileNameForBruteForce = parameters[2];
        Path path3 = Path.of(outputFileNameForBruteForce);
        try {
            Files.newBufferedWriter(path1, StandardOpenOption.TRUNCATE_EXISTING).close();
            Files.newBufferedWriter(path2, StandardOpenOption.TRUNCATE_EXISTING).close();
            Files.newBufferedWriter(path3, StandardOpenOption.TRUNCATE_EXISTING).close();
        } catch (IOException e) {
            throw new FileProcessingException(e.getMessage());
        }
        return new Result("Файлы очищены", ResultCode.OK);
    }
}
