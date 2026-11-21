import java.util.Scanner;

class PrintSum {
    public static void printSum(int first, int second) {
        System.out.println("Sum: " + (first + second));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int first = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int second = scanner.nextInt();
        printSum(first, second);
        scanner.close();
    }
}
