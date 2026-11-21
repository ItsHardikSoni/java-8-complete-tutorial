import java.util.Scanner;

class LargestOfTwo {
    public static int largest(int first, int second) {
        return first >= second ? first : second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();
        System.out.println("Largest: " + largest(first, second));
        scanner.close();
    }
}
