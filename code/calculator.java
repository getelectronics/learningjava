
import java.util.Scanner;

public class calculator {

    // Method to display the menu
    public static void displayMenu() {
        System.out.println("---- Calculator Menu ----");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Modulus");
        System.out.println("6. Exit");
        System.out.print("Choose an operation: ");
    }

    // Method to perform the calculation
    public static void calculate(double num1, double num2, int operation) {
        switch (operation) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero is undefined.");
                }
                break;
            case 5:
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 % num2));
                } else {
                    System.out.println("Error: Modulus by zero is undefined.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main program loop
        while (true) {
            displayMenu(); // Display menu
            int operation = scanner.nextInt(); // Read operation from user

            // If user chooses to exit, break the loop
            if (operation == 6) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            // Get numbers from user
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Perform the calculation based on the user's choice
            calculate(num1, num2, operation);
            System.out.println(); // Print a blank line for readability
        }

        scanner.close(); // Close the scanner
    }
}