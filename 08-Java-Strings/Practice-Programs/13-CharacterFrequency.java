import java.util.Scanner;

class CharacterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        System.out.print("Enter character: ");
        char target = scanner.next().charAt(0);
        int frequency = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) frequency++;
        }
        System.out.println("Frequency: " + frequency);
        scanner.close();
    }
}
