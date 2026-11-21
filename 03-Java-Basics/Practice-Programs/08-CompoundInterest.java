import java.util.Scanner;

class CompoundInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input principal, annual interest rate, time in years, and compounding frequency
        System.out.print("Enter Principal amount (P): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate in % (r): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter time in years (t): ");
        double time = scanner.nextDouble();

        System.out.print("Enter number of times interest is compounded per year (n): ");
        int n = scanner.nextInt();

        // Formula: A = P * (1 + r/n)^(n*t)
        double amount = principal * Math.pow(1 + (rate / 100) / n, n * time);
        double compoundInterest = amount - principal;

        System.out.printf("Compound Interest: %.2f%n", compoundInterest);
        System.out.printf("Total Amount: %.2f%n", amount);

        scanner.close();
    }
}
