import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        System.out.print("Enter element to search: ");
        int target = scanner.nextInt();

        int position = linearSearch(numbers, target);
        if (position == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + position);
        }
        scanner.close();
    }

    private static int linearSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
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
