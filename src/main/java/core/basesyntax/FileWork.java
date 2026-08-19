public String[] readFromFile(String fileName) throws IOException {
    String text = Files.readString(Path.of(fileName));
    return Arrays.stream(text.split("[\\s\\p{Punct}]+"))
            .map(String::toLowerCase)
            .filter(word -> !word.isEmpty() && word.startsWith("w"))
            .sorted()
            .toArray(String[]::new);
}
