import java.util.Scanner;

class LoginSystem {
    static class InvalidCredentialsException extends Exception {
        InvalidCredentialsException(String message) { super(message); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        try {
            if (!username.equals("admin") || !password.equals("admin123")) {
                throw new InvalidCredentialsException("Invalid username or password.");
            }
            System.out.println("Login successful.");
        } catch (InvalidCredentialsException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
