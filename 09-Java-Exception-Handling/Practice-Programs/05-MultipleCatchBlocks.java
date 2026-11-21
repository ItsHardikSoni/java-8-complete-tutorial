import java.util.Scanner;

class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = {10, 20};
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();
            System.out.println(values[index] / divisor);
        } catch (java.lang.ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid array index.");
        } catch (java.lang.ArithmeticException exception) {
            System.out.println("Division by zero.");
        } catch (java.lang.Exception exception) {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }
}
