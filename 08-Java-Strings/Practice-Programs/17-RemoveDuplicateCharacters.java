import java.util.Scanner;

class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            boolean alreadyAdded = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == character) alreadyAdded = true;
            }
            if (!alreadyAdded) result.append(character);
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}
