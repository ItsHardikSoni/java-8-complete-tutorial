abstract class BankAccountBase {
    private String accountNumber;
    private double balance;

    BankAccountBase(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccountBase {
    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    double calculateInterest() {
        return getBalance() * 0.04;
    }
}

class CurrentAccount extends BankAccountBase {
    CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    double calculateInterest() {
        return getBalance() * 0.01;
    }
}

class BankingSystem {
    public static void main(String[] args) {
        BankAccountBase account = new SavingsAccount("S101", 10000);
        account.deposit(2000);
        account.withdraw(1500);
        System.out.println(account.getAccountNumber() + ": " + account.getBalance()
                + ", interest: " + account.calculateInterest());

        BankAccountBase current = new CurrentAccount("C201", 5000);
        System.out.println(current.getAccountNumber() + ": " + current.getBalance());
    }
}
