import java.util.Scanner;

class ThrowKeyword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        try {
            if (age < 18) {
                throw new IllegalArgumentException("Age must be at least 18.");
            }
            System.out.println("Eligible.");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
