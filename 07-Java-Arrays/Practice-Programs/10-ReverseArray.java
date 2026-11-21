import java.util.Scanner;

class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int left = 0, right = size - 1; left < right; left++, right--) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
        }

        System.out.print("Reversed array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        scanner.close();
    }
}
