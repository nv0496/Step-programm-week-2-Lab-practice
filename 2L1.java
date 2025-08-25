public class StringBuiltInMethods {

    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        System.out.println("1. Original Length (with spaces): " + sampleText.length());

        String trimmed = sampleText.trim();
        System.out.println("2. Trimmed String: \"" + trimmed + "\" (Length: " + trimmed.length() + ")");

        System.out.println("3. Character at index 5: " + sampleText.charAt(5));

        String sub = trimmed.substring(5, 16);
        System.out.println("4. Substring: " + sub);

        int funIndex = trimmed.indexOf("Fun");
        System.out.println("5. Index of 'Fun': " + funIndex);

        System.out.println("6. Contains 'Java'? " + trimmed.contains("Java"));

        System.out.println("7. Starts with 'Java'? " + trimmed.startsWith("Java"));

        System.out.println("8. Ends with '!' ? " + trimmed.endsWith("!"));

        System.out.println("9. Uppercase: " + trimmed.toUpperCase());

        System.out.println("10. Lowercase: " + trimmed.toLowerCase());

        System.out.println("11. Number of vowels: " + countVowels(trimmed));

        System.out.print("12. Occurrences of 'a': ");
        findAllOccurrences(trimmed, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("Not found");
        }
        System.out.println();
    }
}
