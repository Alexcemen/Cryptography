package cryptography.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Glossary {
    private final String glossaryFileName = Resource.getGlossaryFileName();
    private final Set<String> glossary = loadGlossary(glossaryFileName);

    public Set<String> getGlossary() {
        return glossary;
    }

    private static Set<String> loadGlossary(String fileName) {
        Set<String> glossary = new HashSet<>();
        Path path = Path.of(fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                glossary.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return glossary;
    }
}
