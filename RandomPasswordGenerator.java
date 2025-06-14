import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
        
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        
        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();
        
        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();
        
        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();
        
        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecial = scanner.nextBoolean();
        
        String characterPool = "";
        if (includeNumbers) characterPool += numbers;
        if (includeLowercase) characterPool += lowercase;
        if (includeUppercase) characterPool += uppercase;
        if (includeSpecial) characterPool += specialChars;
        
        if (characterPool.isEmpty()) {
            System.out.println("You must select at least one character type!");
        } else {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                password.append(characterPool.charAt(random.nextInt(characterPool.length())));
            }
            System.out.println("Generated Password: " + password);
        }
        scanner.close();
    }
}
