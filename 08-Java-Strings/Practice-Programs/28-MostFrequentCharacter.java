import java.util.Scanner;

class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        char most = '\0';
        int highest = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            boolean alreadyChecked = false;
            for (int j = 0; j < i; j++) if (text.charAt(j) == character) alreadyChecked = true;
            if (!alreadyChecked) {
                int count = 0;
                for (int j = 0; j < text.length(); j++) if (text.charAt(j) == character) count++;
                if (count > highest) {
                    highest = count;
                    most = character;
                }
            }
        }
        System.out.println(most == '\0' ? "No character" : "Most frequent: " + most);
        scanner.close();
    }
}
