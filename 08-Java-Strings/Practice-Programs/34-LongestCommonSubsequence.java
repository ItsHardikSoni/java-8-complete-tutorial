import java.util.Scanner;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String first = scanner.nextLine();
        System.out.print("Enter second String: ");
        String second = scanner.nextLine();
        int[][] table = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int i = first.length();
        int j = second.length();
        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                result.append(first.charAt(i - 1));
                i--;
                j--;
            } else if (table[i - 1][j] > table[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("Longest common subsequence: " + result.reverse());
        System.out.println("Length: " + table[first.length()][second.length()]);
        scanner.close();
    }
}
