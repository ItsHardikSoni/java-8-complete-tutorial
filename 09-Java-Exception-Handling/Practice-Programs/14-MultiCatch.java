import java.util.Scanner;

class MultiCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = {10};
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println(values[index] / 0);
        } catch (java.lang.ArrayIndexOutOfBoundsException |
                     java.lang.ArithmeticException exception) {
            System.out.println("Invalid index or arithmetic operation.");
        }
        scanner.close();
    }
}
