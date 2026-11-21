
import java.util.Scanner;

class FibonacciSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int terms = scanner.nextInt();

        if (terms <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            int first = 0;
            int second = 1;
            System.out.print("Fibonacci Series: ");

            for (int i = 1; i <= terms; i++) {
                System.out.print(first + " ");
                int next = first + second;
                first = second;
                second = next;
            }
            System.out.println();
        }

        scanner.close();
    }
}
