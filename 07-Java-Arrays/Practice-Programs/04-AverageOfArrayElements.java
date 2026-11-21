import java.util.Scanner;

class AverageOfArrayElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter " + size + " integers:");
        int sum = 0;
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }

        double average = size == 0 ? 0 : (double) sum / size;
        System.out.println("Average: " + average);
        scanner.close();
    }
}
