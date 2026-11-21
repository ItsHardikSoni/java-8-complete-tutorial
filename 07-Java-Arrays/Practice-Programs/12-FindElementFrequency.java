import java.util.Scanner;

class FindElementFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Enter element: ");
        int target = scanner.nextInt();

        int frequency = 0;
        for (int number : numbers) {
            if (number == target) {
                frequency++;
            }
        }
        System.out.println("Frequency: " + frequency);
        scanner.close();
    }
}
