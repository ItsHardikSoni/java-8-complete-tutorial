class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && !accountNumber.trim().isEmpty()) {
            this.accountNumber = accountNumber;
        } else {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC001", 2500);
        account.setBalance(3000);
        System.out.println(account.getAccountNumber() + ": " + account.getBalance());
    }
}
