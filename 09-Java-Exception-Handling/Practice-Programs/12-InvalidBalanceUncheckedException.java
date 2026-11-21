import java.util.Scanner;

class InvalidBalanceUncheckedException {
    static class InvalidBalanceException extends RuntimeException {
        InvalidBalanceException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        try {
            if (balance < 0) throw new InvalidBalanceException("Balance cannot be negative.");
            System.out.println("Valid balance: " + balance);
        } catch (InvalidBalanceException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
