import java.util.Scanner;

class NestedTry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = {10, 20};
        try {
            try {
                System.out.print("Enter index: ");
                int index = scanner.nextInt();
                System.out.println("Value: " + values[index]);
            } catch (java.lang.ArrayIndexOutOfBoundsException exception) {
                System.out.println("Invalid array index.");
            }
        } finally {
            scanner.close();
        }
    }
}
