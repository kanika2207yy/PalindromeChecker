import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PallindromeChecker {

    // PalindromeStrategy interface
    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    // Stack-based palindrome strategy
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            input = input.toLowerCase().replaceAll("\\s+", "");
            Stack<Character> stack = new Stack<>();
            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }
            for (char ch : input.toCharArray()) {
                if (ch != stack.pop()) return false;
            }
            return true;
        }
    }

    // Deque-based palindrome strategy
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            input = input.toLowerCase().replaceAll("\\s+", "");
            Deque<Character> deque = new LinkedList<>();
            for (char ch : input.toCharArray()) {
                deque.addLast(ch);
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    // Context class to hold the current strategy
    static class PalindromeContext {
        private PalindromeStrategy strategy;

        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean checkPalindrome(String input) {
            return strategy.isPalindrome(input);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy:");
        System.out.println("1. Stack-based");
        System.out.println("2. Deque-based");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);
        boolean result = context.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}