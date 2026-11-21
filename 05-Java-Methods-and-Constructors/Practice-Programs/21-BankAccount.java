import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder) {
        this(accountHolder, 0.0);
    }

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        BankAccount account = new BankAccount(name, 1000);

        account.checkBalance();
        System.out.print("Enter deposit amount: ");
        account.deposit(scanner.nextDouble());
        System.out.print("Enter withdrawal amount: ");
        account.withdraw(scanner.nextDouble());
        account.checkBalance();
        scanner.close();
    }
}
