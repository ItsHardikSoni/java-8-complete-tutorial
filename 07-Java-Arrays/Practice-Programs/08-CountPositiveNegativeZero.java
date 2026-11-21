import java.util.Scanner;

class CountPositiveNegativeZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int positive = 0;
        int negative = 0;
        int zero = 0;

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            if (number > 0) {
                positive++;
            } else if (number < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
        System.out.println("Zero: " + zero);
        scanner.close();
    }
}
