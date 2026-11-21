import java.util.Scanner;

class ArithmeticException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        try {
            System.out.println("Result: " + (dividend / divisor));
        } catch (java.lang.ArithmeticException exception) {
            System.out.println("Cannot divide by zero.");
        }
        scanner.close();
    }
}
