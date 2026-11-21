import java.util.Scanner;

class FindDuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        System.out.print("Duplicate characters: ");
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (firstIndex(text, character) == i) {
                int count = frequency(text, character);
                if (count > 1) {
                    System.out.print(character + " ");
                    found = true;
                }
            }
        }
        if (!found) System.out.print("None");
        System.out.println();
        scanner.close();
    }
    static int firstIndex(String text, char target) {
        for (int i = 0; i < text.length(); i++) if (text.charAt(i) == target) return i;
        return -1;
    }
    static int frequency(String text, char target) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) if (text.charAt(i) == target) count++;
        return count;
    }
}
