import java.util.Scanner;

class BankingManagementSystem {
    static class InsufficientBalanceException extends Exception {
        InsufficientBalanceException(String message) { super(message); }
    }
    static class InvalidTransactionException extends Exception {
        InvalidTransactionException(String message) { super(message); }
    }
    static double balance = 5000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        try {
            if (amount <= 0) throw new InvalidTransactionException("Amount must be greater than zero.");
            if (amount > balance) throw new InsufficientBalanceException("Insufficient balance.");
            balance -= amount;
            System.out.println("Withdrawal successful. Balance: " + balance);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
