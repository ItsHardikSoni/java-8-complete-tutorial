import java.util.Scanner;

class MinMaxSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        System.out.print("Enter subarray size: ");
        int k = scanner.nextInt();

        if (k <= 0 || k > numbers.length) {
            System.out.println("Invalid subarray size");
        } else {
            int windowSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += numbers[i];
            }
            int maximum = windowSum;
            int minimum = windowSum;

            for (int i = k; i < numbers.length; i++) {
                windowSum += numbers[i] - numbers[i - k];
                maximum = Math.max(maximum, windowSum);
                minimum = Math.min(minimum, windowSum);
            }
            System.out.println("Maximum sum: " + maximum);
            System.out.println("Minimum sum: " + minimum);
        }
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
