import java.util.Scanner;

class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        int start = 0;
        int longestStart = 0;
        int longestLength = 0;
        for (int end = 0; end < text.length(); end++) {
            char character = text.charAt(end);
            for (int i = start; i < end; i++) {
                if (text.charAt(i) == character) {
                    start = i + 1;
                    break;
                }
            }
            int length = end - start + 1;
            if (length > longestLength) {
                longestLength = length;
                longestStart = start;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = longestStart; i < longestStart + longestLength; i++) result.append(text.charAt(i));
        System.out.println("Longest substring: " + result);
        scanner.close();
    }
}
