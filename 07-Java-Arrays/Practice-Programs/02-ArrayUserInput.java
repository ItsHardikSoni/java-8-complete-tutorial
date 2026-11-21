import java.util.Scanner;

class ArrayUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Array elements: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        scanner.close();
    }
}
