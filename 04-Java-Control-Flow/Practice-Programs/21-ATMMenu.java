
import java.util.Scanner;

class ATMMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 10000.00;
        int choice;

        do {
            System.out.println("\nATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Available balance: %.2f%n", balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    if (deposit <= 0) {
                        System.out.println("Deposit amount must be positive.");
                    } else {
                        balance += deposit;
                        System.out.printf("Deposited: %.2f%n", deposit);
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal <= 0) {
                        System.out.println("Withdrawal amount must be positive.");
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        System.out.printf("Withdrawn: %.2f%n", withdrawal);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
