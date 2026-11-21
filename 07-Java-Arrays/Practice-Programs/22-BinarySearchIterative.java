import java.util.Arrays;
import java.util.Scanner;

class BinarySearchIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        Arrays.sort(numbers);
        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int low = 0;
        int high = numbers.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] == target) {
                result = mid;
                break;
            } else if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result == -1 ? "Element not found" : "Element found at sorted index " + result);
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
