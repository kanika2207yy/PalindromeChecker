import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class PallindromeChecker {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        input = input.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) stack.push(ch);
        for (char ch : input.toCharArray())
            if (ch != stack.pop()) return false;
        return true;
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        input = input.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    // Recursive palindrome check
    public static boolean recursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursivePalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Stack-based
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(normalized);
        long stackTime = System.nanoTime() - startTime;

        // Deque-based
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(normalized);
        long dequeTime = System.nanoTime() - startTime;

        // Recursive
        startTime = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(normalized, 0, normalized.length() - 1);
        long recursiveTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("\nResults:");
        System.out.printf("Stack-based: %s, Time: %d ns\n", stackResult ? "Palindrome" : "Not Palindrome", stackTime);
        System.out.printf("Deque-based: %s, Time: %d ns\n", dequeResult ? "Palindrome" : "Not Palindrome", dequeTime);
        System.out.printf("Recursive: %s, Time: %d ns\n", recursiveResult ? "Palindrome" : "Not Palindrome", recursiveTime);

        scanner.close();
    }
}