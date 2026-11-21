import java.util.Scanner;

class PairsWithTargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    System.out.println("(" + numbers[i] + ", " + numbers[j] + ")");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No pairs found");
        }
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
