import java.util.Arrays;
import java.util.Scanner;

class CopyArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] source = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            source[i] = scanner.nextInt();
        }

        int[] copy = Arrays.copyOf(source, source.length);
        System.out.println("Copied array: " + Arrays.toString(copy));
        scanner.close();
    }
}
