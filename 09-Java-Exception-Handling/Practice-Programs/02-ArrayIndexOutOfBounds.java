import java.util.Scanner;

class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30};
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        try {
            System.out.println("Value: " + numbers[index]);
        } catch (java.lang.ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index is outside the array bounds.");
        }
        scanner.close();
    }
}
