import java.util.Scanner;

class CountEvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int evenCount = 0;
        int oddCount = 0;

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
        scanner.close();
    }
}
