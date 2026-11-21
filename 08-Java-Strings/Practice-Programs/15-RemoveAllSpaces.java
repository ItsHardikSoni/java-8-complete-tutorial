import java.util.Scanner;

class RemoveAllSpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') result.append(text.charAt(i));
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}
