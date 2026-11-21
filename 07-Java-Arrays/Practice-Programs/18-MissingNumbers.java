import java.util.Scanner;

class MissingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        if (numbers.length == 0) {
            System.out.println("Array is empty");
        } else {
            int minimum = numbers[0];
            int maximum = numbers[0];
            for (int number : numbers) {
                minimum = Math.min(minimum, number);
                maximum = Math.max(maximum, number);
            }

            System.out.print("Missing numbers: ");
            boolean found = false;
            for (int value = minimum; value <= maximum; value++) {
                if (!contains(numbers, value)) {
                    System.out.print(value + " ");
                    found = true;
                }
            }
            if (!found) {
                System.out.print("None");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static boolean contains(int[] numbers, int value) {
        for (int number : numbers) {
            if (number == value) {
                return true;
            }
        }
        return false;
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
