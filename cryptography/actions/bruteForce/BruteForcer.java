package cryptography.actions.bruteForce;

import cryptography.actions.Action;
import cryptography.actions.CaesarCipher;
import cryptography.actions.Decoder;
import cryptography.entity.Result;
import cryptography.entity.ResultCode;
import cryptography.resources.ConsoleColor;
import cryptography.resources.Glossary;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.regex.Pattern;

public class BruteForcer extends CaesarCipher implements Action {
    Glossary glossary = new Glossary();
    private static final ConcurrentMap<ResultKey, Integer> results = new ConcurrentHashMap<>();

    @Override
    public Result execute(String[] parameters) {
        String inputFileName = parameters[0];
        String outputFileName = parameters[1];

        ExecutorService executorService = Executors.newWorkStealingPool();

        for (int key = 0; key < alphabet.getSize(); key++) {
            int finalKey = key;
            executorService.submit(() -> processKey(inputFileName, finalKey));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ResultKey best = results.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        if (best != null) {
            System.out.println("Ключ: " + best.key);
            System.out.println("Разделитель: " + best.delimiter);
            System.out.println("Количество совпадений со словарем: " + results.get(best));
        }

        String[] parametersForDecoder = {inputFileName, outputFileName, String.valueOf(best.key)};
        Decoder decoder = new Decoder();
        decoder.execute(parametersForDecoder);

        return new Result("Расшифровка Brute Force прошла успешно", ResultCode.OK);
    }

    private void processKey(String inputFileName, int key) {
        Path path = Path.of(inputFileName);

        //временное хранилище совпадений по каждому разделителю
        //нужно, чтобы выводить в консоль результат работы каждой нити
        Map<Character, Integer> localMatchesMap = new HashMap<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String decrypted = decrypt(line, key);

                for (int i = 0; i < alphabet.getSize(); i++) {
                    char delimiter = alphabet.getCharByIndex(i);
                    String[] words = decrypted.split(Pattern.quote(String.valueOf(delimiter)));
                    int matches = 0;
                    for (String word : words) {
                        if (glossary.getGlossary().contains(word.toLowerCase())) {
                            matches++;
                        }
                    }
                    localMatchesMap.merge(delimiter, matches, Integer::sum);
                }
            }

            String threadName = Thread.currentThread().getName();
            String color = ConsoleColor.getColorForThread(threadName);
            for (Map.Entry<Character, Integer> entry : localMatchesMap.entrySet()) {
                char delimiter = entry.getKey();
                int matches = entry.getValue();
                results.put(new ResultKey(key, delimiter), matches);
                System.out.println(color + "Нить: " + threadName +
                        " | Ключ: " + key +
                        " | Разделитель: " + delimiter +
                        " | Количество совпадений: " + matches + ConsoleColor.RESET);
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + inputFileName, e);
        }
    }
}
