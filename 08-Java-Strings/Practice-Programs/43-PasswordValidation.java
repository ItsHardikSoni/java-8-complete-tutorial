import java.util.Scanner;

class PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        boolean lengthValid = password.length() >= 8;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean special = false;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (character >= 'A' && character <= 'Z') uppercase = true;
            else if (character >= 'a' && character <= 'z') lowercase = true;
            else if (character >= '0' && character <= '9') digit = true;
            else special = true;
        }
        if (lengthValid && uppercase && lowercase && digit && special) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
            if (!lengthValid) System.out.println("- Must be at least 8 characters");
            if (!uppercase) System.out.println("- Must contain an uppercase letter");
            if (!lowercase) System.out.println("- Must contain a lowercase letter");
            if (!digit) System.out.println("- Must contain a digit");
            if (!special) System.out.println("- Must contain a special character");
        }
        scanner.close();
    }
}
