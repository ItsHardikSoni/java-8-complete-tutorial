import java.util.Scanner;

class CountWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        int words = 0;
        boolean inWord = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\t') {
                inWord = false;
            } else if (!inWord) {
                words++;
                inWord = true;
            }
        }
        System.out.println("Word count: " + words);
        scanner.close();
    }
}
