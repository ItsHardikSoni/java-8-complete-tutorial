import java.util.Scanner;

class BankingMenu {
    private double balance;
    private Scanner scanner;

    public BankingMenu(double initialBalance) {
        balance = initialBalance;
        scanner = new Scanner(System.in);
    }

    public void checkBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }

    public void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            balance += amount;
            System.out.println("Deposited successfully.");
        }
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn successfully.");
        }
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nBanking Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the banking application.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        new BankingMenu(10000).run();
    }
}
