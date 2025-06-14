import java.io.*;
import java.util.Scanner;

public class FileEncryptor{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter output file path: ");
        String outputFilePath = scanner.nextLine();
        System.out.print("Enter shift key (number): ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Encrypt or Decrypt? (E/D): ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);
        scanner.close();
        
        boolean encrypt = (choice == 'E');
        processFile(filePath, outputFilePath, shift, encrypt);
    }
    
    private static void processFile(String inputFile, String outputFile, int shift, boolean encrypt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(transform(line, shift, encrypt) + "\n");
            }
            System.out.println("Process completed. Output saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static String transform(String text, int shift, boolean encrypt) {
        if (!encrypt) shift = -shift;
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (base + (c - base + shift + 26) % 26);
            }
            result.append(c);
        }
        return result.toString();
    }
}
