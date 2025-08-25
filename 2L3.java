import java.util.*;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            System.out.println("Character: " + ch + " | ASCII: " + ascii);
            System.out.println("Type: " + classifyCharacter(ch));

            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Uppercase: " + upper + " (" + (int) upper + ")");
                System.out.println("Lowercase: " + lower + " (" + (int) lower + ")");
                System.out.println("Difference (Upper - Lower): " + ((int) upper - (int) lower));
            }
            System.out.println();
        }

        System.out.println("ASCII Table (65–90):");
        displayASCIITable(65, 90);

        System.out.print("\nEnter shift value for Caesar Cipher: ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        String encrypted = caesarCipher(input, shift);
        System.out.println("Encrypted (Caesar Cipher): " + encrypted);
        System.out.println("Decrypted: " + caesarCipher(encrypted, -shift));

        int[] asciiArray = stringToASCII(input);
        System.out.println("\nString to ASCII Array: " + Arrays.toString(asciiArray));
        System.out.println("Back to String: " + asciiToString(asciiArray));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) (ch + 32); // A–Z to a–z
        } else if (Character.isLowerCase(ch)) {
            return (char) (ch - 32); // a–z to A–Z
        }
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + shift + 26) % 26 + base);
                sb.append(shifted);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = (int) text.charAt(i);
        }
        return arr;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}
