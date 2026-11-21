import java.util.Arrays;
import java.util.Scanner;

class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        bubbleSort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        scanner.close();
    }

    private static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
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
