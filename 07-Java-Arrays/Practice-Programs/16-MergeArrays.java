import java.util.Arrays;
import java.util.Scanner;

class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = readArray(scanner, "first");
        int[] second = readArray(scanner, "second");
        int[] merged = new int[first.length + second.length];

        System.arraycopy(first, 0, merged, 0, first.length);
        System.arraycopy(second, 0, merged, first.length, second.length);
        System.out.println("Merged array: " + Arrays.toString(merged));
        scanner.close();
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
