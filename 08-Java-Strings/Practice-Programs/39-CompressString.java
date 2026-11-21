import java.util.Scanner;

class CompressString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        if (text.length() == 0) {
            System.out.println("Compressed: ");
        } else {
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < text.length()) {
                char character = text.charAt(i);
                int count = 1;
                while (i + count < text.length() && text.charAt(i + count) == character) count++;
                result.append(character).append(count);
                i += count;
            }
            System.out.println("Compressed: " + result);
        }
        scanner.close();
    }
}
