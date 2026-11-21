import java.util.Scanner;

class AllPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        System.out.println("Permutations:");
        permute(text.toCharArray(), 0);
        scanner.close();
    }
    static void permute(char[] characters, int index) {
        if (index == characters.length) {
            System.out.println(new String(characters));
            return;
        }
        for (int i = index; i < characters.length; i++) {
            boolean duplicate = false;
            for (int j = index; j < i; j++) if (characters[j] == characters[i]) duplicate = true;
            if (!duplicate) {
                char temp = characters[index];
                characters[index] = characters[i];
                characters[i] = temp;
                permute(characters, index + 1);
                temp = characters[index];
                characters[index] = characters[i];
                characters[i] = temp;
            }
        }
    }
}
