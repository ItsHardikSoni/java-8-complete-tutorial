import java.util.Scanner;

class BasicReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter text to replace: ");
        String target = scanner.nextLine();
        System.out.print("Enter replacement: ");
        String replacement = scanner.nextLine();
        if (target.length() == 0) {
            System.out.println("Result: " + text);
        } else {
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < text.length()) {
                boolean match = i + target.length() <= text.length();
                if (match) {
                    for (int j = 0; j < target.length(); j++) {
                        if (text.charAt(i + j) != target.charAt(j)) {
                            match = false;
                            break;
                        }
                    }
                }
                if (match) {
                    result.append(replacement);
                    i += target.length();
                } else {
                    result.append(text.charAt(i));
                    i++;
                }
            }
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}
