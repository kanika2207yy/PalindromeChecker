import java.util.Scanner;
import java.util.Stack;

public class PallindromeChecker {

    // PalindromeChecker class encapsulates palindrome logic
    static class PalindromeChecker {

        // Method to check palindrome
        public boolean checkPalindrome(String input) {
            if (input == null || input.isEmpty()) {
                return true;
            }

            // Normalize string: lowercase and remove spaces
            input = input.toLowerCase().replaceAll("\\s+", "");

            // Use stack to reverse string
            Stack<Character> stack = new Stack<>();
            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }

            // Compare characters
            for (char ch : input.toCharArray()) {
                if (ch != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}