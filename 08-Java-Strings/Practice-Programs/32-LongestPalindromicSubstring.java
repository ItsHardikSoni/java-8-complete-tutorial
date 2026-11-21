import java.util.Scanner;

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        int start = 0;
        int longest = 0;
        for (int center = 0; center < text.length() - 1; center++) {
            int left = center;
            int right = center + 1;
            while (left >= 0 && right < text.length() && text.charAt(left) == text.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            int length = right - left + 1;
            if (length > longest) {
                longest = length;
                start = left;
            }
        }
        for (int center = 0; center < text.length(); center++) {
            int left = center;
            int right = center;
            while (left >= 0 && right < text.length() && text.charAt(left) == text.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            int length = right - left + 1;
            if (length > longest) {
                longest = length;
                start = left;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < start + longest; i++) result.append(text.charAt(i));
        System.out.println("Longest palindromic substring: " + result);
        scanner.close();
    }
}
