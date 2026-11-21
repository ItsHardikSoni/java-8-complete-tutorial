import java.util.Scanner;

class SumOfDigits {
    public static int sumOfDigits(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 0;
        }
        return number % 10 + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("Sum of digits: " + sumOfDigits(number));
        scanner.close();
    }
}
