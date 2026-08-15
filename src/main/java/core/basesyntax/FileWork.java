import java.io.;
import java.util.;

public class FileWork {

    public static String[] readFromFile(String filename) {
        List<String> result = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(filename))) {

            StringBuilder text = new StringBuilder();

            while (sc.hasNextLine()) {
                text.append(sc.nextLine()).append(" ");
            }

            String[] words = text.toString().split("[\\s\\p{Punct}]+");

            for (String word : words) {
                word = word.toLowerCase();

                if (word.startsWith("w")) {
                    result.add(word);
                }
            }

        } catch (IOException e) {
            return new String[0];
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] result = readFromFile("liczby.txt");

        System.out.println(Arrays.toString(result));
    }
}