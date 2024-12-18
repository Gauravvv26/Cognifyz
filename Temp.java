import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        if (unit == 'C') {
            double fahrenheit = (temperature * 9/5) + 32;
            System.out.printf("%.2f Celsius is %.2f Fahrenheit%n", temperature, fahrenheit);
        } else if (unit == 'F') {
            double celsius = (temperature - 32) * 5/9;
            System.out.printf("%.2f Fahrenheit is %.2f Celsius%n", temperature, celsius);
        } else {
            System.out.println("Invalid unit! Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }

        scanner.close();
    }
}

