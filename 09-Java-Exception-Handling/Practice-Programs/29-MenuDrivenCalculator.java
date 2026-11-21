import java.util.InputMismatchException;
import java.util.Scanner;

class MenuDrivenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            double first = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double second = scanner.nextDouble();
            System.out.print("Choose operation (+ - * /): ");
            char operation = scanner.next().charAt(0);
            double result;
            switch (operation) {
                case '+': result = first + second; break;
                case '-': result = first - second; break;
                case '*': result = first * second; break;
                case '/':
                    if (second == 0) throw new java.lang.ArithmeticException("Cannot divide by zero.");
                    result = first / second;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation.");
            }
            System.out.println("Result: " + result);
        } catch (InputMismatchException exception) {
            System.out.println("Please enter numeric values.");
        } catch (java.lang.ArithmeticException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
