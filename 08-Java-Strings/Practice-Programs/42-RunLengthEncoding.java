import java.util.Scanner;

class RunLengthEncoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        StringBuilder encoded = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            char character = text.charAt(i);
            int count = 1;
            while (i + count < text.length() && text.charAt(i + count) == character) count++;
            encoded.append(character).append(count);
            i += count;
        }
        System.out.println("Encoded: " + encoded);
        scanner.close();
    }
}
