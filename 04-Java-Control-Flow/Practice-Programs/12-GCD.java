
import java.util.Scanner;

class GCD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        first = Math.abs(first);
        second = Math.abs(second);

        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }

        System.out.println("GCD: " + first);
        scanner.close();
    }
}
