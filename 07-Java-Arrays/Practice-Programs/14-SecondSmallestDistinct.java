import java.util.Scanner;

class SecondSmallestDistinct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        Integer first = null;
        Integer second = null;
        for (int number : numbers) {
            if (first == null || number < first) {
                second = first;
                first = number;
            } else if (number != first && (second == null || number < second)) {
                second = number;
            }
        }

        System.out.println(second == null ? "No second smallest distinct element" : "Second smallest: " + second);
        scanner.close();
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
