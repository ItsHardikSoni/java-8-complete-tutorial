import java.util.Scanner;

class StringContainsOnlyDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        boolean onlyDigits = text.length() > 0;
        for (int i = 0; i < text.length() && onlyDigits; i++) {
            char character = text.charAt(i);
            if (character < '0' || character > '9') onlyDigits = false;
        }
        System.out.println(onlyDigits ? "Contains only digits" : "Does not contain only digits");
        scanner.close();
    }
}
