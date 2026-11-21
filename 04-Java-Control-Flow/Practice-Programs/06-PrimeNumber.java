
import java.util.Scanner;

class PrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 2) {
            System.out.println(number + " is not a prime number.");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= number / i; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.println(number + (isPrime ? " is a prime number." : " is not a prime number."));
        }

        scanner.close();
    }
}
