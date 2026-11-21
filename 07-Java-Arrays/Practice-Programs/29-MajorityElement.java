import java.util.Scanner;

class MajorityElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);

        int candidate = findCandidate(numbers);
        int count = 0;
        for (int number : numbers) {
            if (number == candidate) {
                count++;
            }
        }

        if (count > numbers.length / 2) {
            System.out.println("Majority element: " + candidate);
        } else {
            System.out.println("No majority element");
        }
        scanner.close();
    }

    private static int findCandidate(int[] numbers) {
        int count = 0;
        int candidate = 0;
        for (int number : numbers) {
            if (count == 0) {
                candidate = number;
            }
            count += number == candidate ? 1 : -1;
        }
        return candidate;
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
