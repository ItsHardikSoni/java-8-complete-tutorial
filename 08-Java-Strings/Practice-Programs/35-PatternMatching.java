import java.util.Scanner;

class PatternMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) found = true;
        }
        System.out.println(found ? "Pattern found" : "Pattern not found");
        scanner.close();
    }
}
