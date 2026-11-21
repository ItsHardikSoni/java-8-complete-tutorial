class BankAccount {
    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    synchronized boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    synchronized int getBalance() {
        return balance;
    }
}

class ThreadSafeBankWithdrawal {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);
        Thread first = new Thread(() -> {
            boolean success = account.withdraw(700);
            System.out.println("First withdrawal: " + success);
        });
        Thread second = new Thread(() -> {
            boolean success = account.withdraw(500);
            System.out.println("Second withdrawal: " + success);
        });
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Balance: " + account.getBalance());
    }
}
