import java.util.Scanner;

class ReverseString {
    public static String reverse(String text) {
        if (text.isEmpty()) {
            return text;
        }
        return text.charAt(text.length() - 1) + reverse(text.substring(0, text.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        System.out.println("Reversed: " + reverse(text));
        scanner.close();
    }
}
