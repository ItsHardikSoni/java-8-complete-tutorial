import java.util.Scanner;

class InvalidAgeCheckedException {
    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        try {
            validateAge(age);
        } catch (InvalidAgeException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) throw new InvalidAgeException("Invalid age.");
        System.out.println("Valid age.");
    }
}
