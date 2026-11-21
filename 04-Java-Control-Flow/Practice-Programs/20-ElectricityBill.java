
import java.util.Scanner;

class ElectricityBill {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter electricity units consumed: ");
        int units = scanner.nextInt();

        if (units < 0) {
            System.out.println("Units cannot be negative.");
        } else {
            double bill;
            if (units <= 100) {
                bill = units * 1.50;
            } else if (units <= 200) {
                bill = 100 * 1.50 + (units - 100) * 2.50;
            } else if (units <= 300) {
                bill = 100 * 1.50 + 100 * 2.50 + (units - 200) * 4.00;
            } else {
                bill = 100 * 1.50 + 100 * 2.50 + 100 * 4.00 + (units - 300) * 6.00;
            }

            System.out.printf("Total electricity bill: %.2f%n", bill);
        }

        scanner.close();
    }
}
