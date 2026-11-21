import java.util.Arrays;
import java.util.Scanner;

class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        for (int i = 0; i < numbers.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minimumIndex];
            numbers[minimumIndex] = temp;
        }

        System.out.println("Sorted array: " + Arrays.toString(numbers));
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
