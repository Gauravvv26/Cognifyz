import java.util.Scanner;

public class PasswordStrengthChecker{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();
        
        int strength = checkPasswordStrength(password);
        
        if (strength <= 2) {
            System.out.println("Weak Password");
        } else if (strength == 3) {
            System.out.println("Moderate Password");
        } else {
            System.out.println("Strong Password");
        }
    }
    
    private static int checkPasswordStrength(String password) {
        int strength = 0;
        if (password.length() >= 8) strength++;
        if (password.matches(".*[A-Z].*")) strength++;
        if (password.matches(".*[a-z].*")) strength++;
        if (password.matches(".*[0-9].*")) strength++;
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) strength++; // Fixed regex

        return strength;
    }
}
