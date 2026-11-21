import java.util.Scanner;

class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = readArray(scanner, "first");
        int[] second = readArray(scanner, "second");

        System.out.print("Common elements: ");
        boolean found = false;
        for (int i = 0; i < first.length; i++) {
            if (contains(second, first[i]) && !contains(first, i, first[i])) {
                System.out.print(first[i] + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
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

    private static boolean contains(int[] numbers, int endIndex, int value) {
        for (int i = 0; i < endIndex; i++) {
            if (numbers[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static int[] readArray(Scanner scanner, String name) {
        System.out.print("Enter size of " + name + " array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}
