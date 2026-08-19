package core.basesyntax; // Upewnij się, że masz tę linię
// Dodaj te importy na początku pliku
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
public class FileWork { // Metoda musi być wewnątrz klasy!
    public String[] readFromFile(String fileName) throws IOException {
        String text = Files.readString(Path.of(fileName));
        return Arrays.stream(text.split("[\\s\\p{Punct}]+"))
                .map(String::toLowerCase)
                .filter(word -> !word.isEmpty() && word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
