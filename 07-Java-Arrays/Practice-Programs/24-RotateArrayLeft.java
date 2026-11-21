import java.util.Arrays;
import java.util.Scanner;

class RotateArrayLeft {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        System.out.print("Enter positions to rotate left: ");
        int positions = scanner.nextInt();
        if (numbers.length > 0) {
            positions %= numbers.length;
            reverse(numbers, 0, positions - 1);
            reverse(numbers, positions, numbers.length - 1);
            reverse(numbers, 0, numbers.length - 1);
        }
        System.out.println("Rotated array: " + Arrays.toString(numbers));
        scanner.close();
    }

    private static void reverse(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start++] = numbers[end];
            numbers[end--] = temp;
        }
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
