import java.util.Scanner;

class BasicIndexOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter search String: ");
        String search = scanner.nextLine();
        int result = -1;
        if (search.length() <= text.length()) {
            for (int i = 0; i <= text.length() - search.length(); i++) {
                boolean match = true;
                for (int j = 0; j < search.length(); j++) {
                    if (text.charAt(i + j) != search.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println("Index: " + result);
        scanner.close();
    }
}
