import java.util.Scanner;

class MaximumContiguousSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        if (numbers.length == 0) {
            System.out.println("Maximum sum contiguous subarray: 0");
        } else {
            int currentSum = numbers[0];
            int maximumSum = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                currentSum = Math.max(numbers[i], currentSum + numbers[i]);
                maximumSum = Math.max(maximumSum, currentSum);
            }
            System.out.println("Maximum sum contiguous subarray: " + maximumSum);
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
