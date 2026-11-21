import java.util.Arrays;
import java.util.Scanner;

class MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        int position = 0;
        for (int number : numbers) {
            if (number != 0) {
                numbers[position++] = number;
            }
        }
        while (position < numbers.length) {
            numbers[position++] = 0;
        }

        System.out.println("Result: " + Arrays.toString(numbers));
        scanner.close();
    }

    private static int[] readArray(Scanner scanner) {
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}
