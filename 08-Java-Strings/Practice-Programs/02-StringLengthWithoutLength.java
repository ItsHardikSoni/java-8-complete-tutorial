import java.util.Scanner;

class StringLengthWithoutLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        char[] characters = text.toCharArray();
        int length = 0;
        for (char character : characters) {
            length++;
        }
        System.out.println("Length: " + length);
        scanner.close();
    }
}
