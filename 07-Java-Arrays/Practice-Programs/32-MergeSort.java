import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        scanner.close();
    }

    private static void mergeSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(numbers, left, middle);
        mergeSort(numbers, middle + 1, right);
        merge(numbers, left, middle, right);
    }

    private static void merge(int[] numbers, int left, int middle, int right) {
        int[] leftArray = Arrays.copyOfRange(numbers, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(numbers, middle + 1, right + 1);
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                numbers[k++] = leftArray[i++];
            } else {
                numbers[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            numbers[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            numbers[k++] = rightArray[j++];
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
