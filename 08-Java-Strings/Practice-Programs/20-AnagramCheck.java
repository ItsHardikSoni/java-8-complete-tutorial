import java.util.Scanner;

class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String first = scanner.nextLine();
        System.out.print("Enter second String: ");
        String second = scanner.nextLine();
        if (first.length() != second.length()) {
            System.out.println("Not Anagrams");
        } else {
            char[] chars = first.toCharArray();
            boolean[] used = new boolean[second.length()];
            boolean anagram = true;
            for (char character : chars) {
                boolean matched = false;
                for (int j = 0; j < second.length(); j++) {
                    if (!used[j] && second.charAt(j) == character) {
                        used[j] = true;
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    anagram = false;
                    break;
                }
            }
            System.out.println(anagram ? "Anagrams" : "Not Anagrams");
        }
        scanner.close();
    }
}
