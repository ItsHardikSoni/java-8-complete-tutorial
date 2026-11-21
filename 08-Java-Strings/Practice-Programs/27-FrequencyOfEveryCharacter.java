import java.util.Scanner;

class FrequencyOfEveryCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            boolean printed = false;
            for (int j = 0; j < i; j++) if (text.charAt(j) == character) printed = true;
            if (!printed) {
                int count = 0;
                for (int j = 0; j < text.length(); j++) if (text.charAt(j) == character) count++;
                System.out.println(character + ": " + count);
            }
        }
        scanner.close();
    }
}
