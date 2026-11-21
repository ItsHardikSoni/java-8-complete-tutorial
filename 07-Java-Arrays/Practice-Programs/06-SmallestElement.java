import java.util.Scanner;

class SmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        if (size == 0) {
            System.out.println("Array is empty");
        } else {
            int smallest = numbers[0];
            for (int i = 1; i < size; i++) {
                if (numbers[i] < smallest) {
                    smallest = numbers[i];
                }
            }
            System.out.println("Smallest element: " + smallest);
        }
        scanner.close();
    }
}
