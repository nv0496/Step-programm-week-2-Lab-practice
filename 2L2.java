import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence with mixed formatting:");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        String replaced = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced with underscores: " + replaced);

        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("Without digits: " + noDigits);

        String[] words = trimmed.split("\\s+");
        System.out.println("Words array: " + Arrays.toString(words));

        String joined = String.join(" | ", words);
        System.out.println("Rejoined with '|': " + joined);

        String noPunctuation = removePunctuation(trimmed);
        System.out.println("Without punctuation: " + noPunctuation);

        String capitalized = capitalizeWords(noPunctuation);
        System.out.println("Capitalized words: " + capitalized);

        String reversed = reverseWordOrder(trimmed);
        System.out.println("Reversed word order: " + reversed);

        System.out.println("Word Frequency:");
        countWordFrequency(trimmed);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

