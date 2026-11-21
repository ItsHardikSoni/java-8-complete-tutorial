import java.util.Scanner;

class PaymentProcessingSystem {
    static class PaymentFailedException extends Exception {
        PaymentFailedException(String message) { super(message); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        try {
            if (amount <= 0) throw new PaymentFailedException("Invalid payment amount.");
            if (amount > 50000) throw new PaymentFailedException("Payment limit exceeded.");
            System.out.println("Payment processed successfully.");
        } catch (PaymentFailedException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
