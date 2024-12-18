import java.util.Scanner;

public class pal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        String sanitizedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;
        int length = sanitizedInput.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (sanitizedInput.charAt(i) != sanitizedInput.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }

        scanner.close();
    }
}
