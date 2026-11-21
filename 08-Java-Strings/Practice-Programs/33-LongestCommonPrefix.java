import java.util.Scanner;

class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Strings? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        String[] texts = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter String " + (i + 1) + ": ");
            texts[i] = scanner.nextLine();
        }
        if (count == 0) {
            System.out.println("Longest common prefix:");
        } else {
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < texts[0].length(); i++) {
                char character = texts[0].charAt(i);
                boolean common = true;
                for (int j = 1; j < count; j++) {
                    if (i >= texts[j].length() || texts[j].charAt(i) != character) {
                        common = false;
                        break;
                    }
                }
                if (!common) break;
                prefix.append(character);
            }
            System.out.println("Longest common prefix: " + prefix);
        }
        scanner.close();
    }
}
