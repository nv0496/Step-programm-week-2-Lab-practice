import java.util.Scanner;

public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        performAllComparisons(str1, str2);

        long startTime = System.nanoTime();
        String[] inputs = {str1, str2, "extra", "test"};
        String processed = optimizedStringProcessing(inputs);
        long endTime = System.nanoTime();
        System.out.println("Optimized processing result: " + processed);
        System.out.println("Processing time: " + (endTime - startTime) + " ns");

        analyzeMemoryUsage(str1, str2);
        demonstrateStringIntern();
        scanner.close();
    }

    public static double calculateSimilarity(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        int distance = dp[len1][len2];
        int maxLen = Math.max(len1, len2);
        return (1 - (double) distance / maxLen) * 100;
    }

    public static void performAllComparisons(String str1, String str2) {
        System.out.println("\n=== Comparisons ===");
        System.out.println("== operator: " + (str1 == str2));
        System.out.println("equals: " + str1.equals(str2));
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase(str2));
        System.out.println("compareTo: " + str1.compareTo(str2));
        System.out.println("compareToIgnoreCase: " + str1.compareToIgnoreCase(str2));
        System.out.printf("Similarity: %.2f%%\n", calculateSimilarity(str1, str2));
    }

    public static void analyzeMemoryUsage(String... strings) {
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.freeMemory();
        String temp = "";
        for (String s : strings) temp += s;
        long after = runtime.freeMemory();
        System.out.println("\nMemory used: " + (before - after));
    }

    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) sb.append(s).append(" ");
        return sb.toString().trim();
    }

    public static void demonstrateStringIntern() {
        System.out.println("\n=== intern() Demo ===");
        String s1 = new String("Hello");
        String s2 = "Hello";
        String s3 = s1.intern();
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s2 == s3: " + (s2 == s3));
    }
}
