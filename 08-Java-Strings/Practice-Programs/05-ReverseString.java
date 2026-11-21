import java.util.Scanner;

class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        char[] result = text.toCharArray();
        for (int left = 0, right = result.length - 1; left < right; left++, right--) {
            char temp = result[left];
            result[left] = result[right];
            result[right] = temp;
        }
        System.out.println("Reversed String: " + new String(result));
        scanner.close();
    }
}
