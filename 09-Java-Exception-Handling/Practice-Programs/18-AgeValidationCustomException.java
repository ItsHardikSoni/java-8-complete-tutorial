import java.util.Scanner;

class AgeValidationCustomException {
    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) { super(message); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        try {
            if (age < 18) throw new InvalidAgeException("Age must be at least 18.");
            if (age > 100) throw new InvalidAgeException("Age is outside the valid range.");
            System.out.println("Age accepted.");
        } catch (InvalidAgeException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
