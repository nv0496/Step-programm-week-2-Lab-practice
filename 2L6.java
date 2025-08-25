import java.util.*;

public class StringUtilityApp {
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== STRING UTILITY APPLICATION ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Text Analysis");
            System.out.println("2. String Transformation");
            System.out.println("3. ASCII Operations");
            System.out.println("4. Performance Testing");
            System.out.println("5. String Comparison Analysis");
            System.out.println("6. Custom String Algorithms");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text1 = scanner.nextLine();
                    performTextAnalysis(text1);
                    break;
                case 2:
                    System.out.print("Enter text: ");
                    String text2 = scanner.nextLine();
                    System.out.print("Enter operations (comma separated - trim,upper,lower,replace:old:new): ");
                    String[] ops = scanner.nextLine().split(",");
                    String transformed = performTransformations(text2, ops);
                    output.append("Transformed: ").append(transformed).append("\n");
                    break;
                case 3:
                    System.out.print("Enter text: ");
                    String text3 = scanner.nextLine();
                    performASCIIOperations(text3);
                    break;
                case 4:
                    System.out.print("Enter number of iterations: ");
                    int iter = Integer.parseInt(scanner.nextLine());
                    performPerformanceTest(iter);
                    break;
                case 5:
                    System.out.print("Enter strings (comma separated): ");
                    String[] strs = scanner.nextLine().split(",");
                    performComparisonAnalysis(strs);
                    break;
                case 6:
                    System.out.print("Enter text: ");
                    String text6 = scanner.nextLine();
                    performCustomAlgorithms(text6);
                    break;
                case 7:
                    displayResults();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void performTextAnalysis(String text) {
        output.append("\n=== TEXT ANALYSIS ===\n");
        output.append("Length: ").append(text.length()).append("\n");
        String[] words = text.trim().split("\\s+");
        output.append("Words: ").append(words.length).append("\n");
        output.append("Sentences: ").append(text.split("[.!?]").length).append("\n");
        output.append("Paragraphs: ").append(text.split("\\n").length).append("\n");

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        output.append("Character Frequency: ").append(freq.toString()).append("\n");
    }

    public static String performTransformations(String text, String[] operations) {
        StringBuilder sb = new StringBuilder(text);
        String result = sb.toString();
        for (String op : operations) {
            if (op.equalsIgnoreCase("trim")) result = result.trim();
            else if (op.equalsIgnoreCase("upper")) result = result.toUpperCase();
            else if (op.equalsIgnoreCase("lower")) result = result.toLowerCase();
            else if (op.startsWith("replace:")) {
                String[] parts = op.split(":");
                if (parts.length == 3) result = result.replace(parts[1], parts[2]);
            }
        }
        return result;
    }

    public static void performASCIIOperations(String text) {
        output.append("\n=== ASCII OPERATIONS ===\n");
        for (char c : text.toCharArray()) {
            output.append(c).append(" -> ").append((int) c).append("\n");
        }
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) encrypted.append((char) (c + 1));
        output.append("Encrypted (+1 shift): ").append(encrypted.toString()).append("\n");

        StringBuilder decrypted = new StringBuilder();
        for (char c : encrypted.toString().toCharArray()) decrypted.append((char) (c - 1));
        output.append("Decrypted: ").append(decrypted.toString()).append("\n");
    }

    public static void performPerformanceTest(int iterations) {
        output.append("\n=== PERFORMANCE TEST ===\n");
        long start, end;

        start = System.nanoTime();
        String s = "";
        for (int i = 0; i < iterations; i++) s += "x";
        end = System.nanoTime();
        output.append("String: ").append(end - start).append(" ns\n");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append("x");
        sb.toString();
        end = System.nanoTime();
        output.append("StringBuilder: ").append(end - start).append(" ns\n");

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) sbf.append("x");
        sbf.toString();
        end = System.nanoTime();
        output.append("StringBuffer: ").append(end - start).append(" ns\n");
    }

    public static void performComparisonAnalysis(String[] strings) {
        output.append("\n=== COMPARISON ANALYSIS ===\n");
        if (strings.length < 2) {
            output.append("Need at least two strings.\n");
            return;
        }
        String str1 = strings[0], str2 = strings[1];
        output.append("Reference equality: ").append(str1 == str2).append("\n");
        output.append("Content equality: ").append(str1.equals(str2)).append("\n");
        output.append("Case-insensitive equality: ").append(str1.equalsIgnoreCase(str2)).append("\n");
        output.append("compareTo: ").append(str1.compareTo(str2)).append("\n");
        output.append("compareToIgnoreCase: ").append(str1.compareToIgnoreCase(str2)).append("\n");
    }

    public static void performCustomAlgorithms(String text) {
        output.append("\n=== CUSTOM ALGORITHMS ===\n");
        String rev = new StringBuilder(text).reverse().toString();
        output.append("Palindrome: ").append(text.equalsIgnoreCase(rev)).append("\n");

        char[] arr = text.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(arr);
        output.append("Sorted chars (for anagram use): ").append(new String(arr)).append("\n");

        output.append("Contains pattern 'test': ").append(text.toLowerCase().contains("test")).append("\n");
    }

    public static void displayResults() {
        System.out.println("\n=== RESULTS ===");
        System.out.println(output.toString());
    }
}
