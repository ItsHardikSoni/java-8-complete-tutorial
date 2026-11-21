import java.util.Scanner;

class RemoveDuplicateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine().trim();
        if (text.length() == 0) {
            System.out.println("Result:");
        } else {
            String[] words = text.split("\\s+");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                boolean duplicate = false;
                for (int j = 0; j < i; j++) {
                    if (words[i].equals(words[j])) duplicate = true;
                }
                if (!duplicate) {
                    if (result.length() > 0) result.append(' ');
                    result.append(words[i]);
                }
            }
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}
