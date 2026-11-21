import java.util.Scanner;

class AllSubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        System.out.println("Substrings:");
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                System.out.println(text.substring(i, j));
            }
        }
        scanner.close();
    }
}
