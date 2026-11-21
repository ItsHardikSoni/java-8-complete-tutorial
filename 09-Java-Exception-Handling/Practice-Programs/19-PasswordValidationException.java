import java.util.Scanner;

class PasswordValidationException {
    static class InvalidPasswordException extends Exception {
        InvalidPasswordException(String message) { super(message); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        try {
            if (password.length() < 8) throw new InvalidPasswordException("Password must contain at least 8 characters.");
            if (password.equals(password.toLowerCase())) throw new InvalidPasswordException("Password must contain an uppercase letter.");
            if (password.equals(password.toUpperCase())) throw new InvalidPasswordException("Password must contain a lowercase letter.");
            System.out.println("Password accepted.");
        } catch (InvalidPasswordException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
