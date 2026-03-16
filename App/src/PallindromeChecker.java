import java.util.Scanner;

public class PallindromeChecker {

    // Method to check palindrome ignoring case and spaces
    public static boolean isPalindrome(String input) {

        // Normalize string: lowercase and remove all spaces
        input = input.toLowerCase().replaceAll("\\s+", "");

        int start = 0;
        int end = input.length() - 1;

        // Compare characters from start and end
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}