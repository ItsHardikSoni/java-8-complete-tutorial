import java.util.InputMismatchException;
import java.util.Scanner;

class ScannerInvalidInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (InputMismatchException exception) {
            System.out.println("Invalid input. Please enter only integers.");
        } finally {
            scanner.close();
        }
    }
}
