import java.util.Arrays;
import java.util.Scanner;

class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        Arrays.sort(numbers);
        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int result = binarySearch(numbers, 0, numbers.length - 1, target);
        System.out.println(result == -1 ? "Element not found" : "Element found at sorted index " + result);
        scanner.close();
    }

    private static int binarySearch(int[] numbers, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (numbers[mid] == target) {
            return mid;
        }
        if (numbers[mid] > target) {
            return binarySearch(numbers, low, mid - 1, target);
        }
        return binarySearch(numbers, mid + 1, high, target);
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
