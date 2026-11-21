import java.util.Scanner;

class CompareStringsWithoutEquals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String first = scanner.nextLine();
        System.out.print("Enter second String: ");
        String second = scanner.nextLine();
        boolean equal = first.length() == second.length();
        if (equal) {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    equal = false;
                    break;
                }
            }
        }
        System.out.println(equal ? "Strings are equal" : "Strings are not equal");
        scanner.close();
    }
}
