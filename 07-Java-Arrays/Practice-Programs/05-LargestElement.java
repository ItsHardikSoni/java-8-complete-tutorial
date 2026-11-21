import java.util.Scanner;

class LargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        if (numbers.length == 0) {
            System.out.println("Array is empty");
        } else {
            int largest = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > largest) {
                    largest = numbers[i];
                }
            }
            System.out.println("Largest element: " + largest);
        }
        scanner.close();
    }

    private static int[] readArray(Scanner scanner) {
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}
