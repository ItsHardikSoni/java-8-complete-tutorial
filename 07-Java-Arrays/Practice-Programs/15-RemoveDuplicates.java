import java.util.Scanner;

class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        int[] result = new int[numbers.length];
        int resultSize = 0;
        for (int number : numbers) {
            boolean found = false;
            for (int i = 0; i < resultSize; i++) {
                if (result[i] == number) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[resultSize++] = number;
            }
        }

        System.out.print("Unique elements: ");
        for (int i = 0; i < resultSize; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
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
