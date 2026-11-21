import java.util.Scanner;

class AcceptAndDisplayString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        System.out.println("String: " + text);
        scanner.close();
    }
}
