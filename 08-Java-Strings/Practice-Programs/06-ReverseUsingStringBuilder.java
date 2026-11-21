import java.util.Scanner;

class ReverseUsingStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        System.out.println("Reversed String: " + new StringBuilder(text).reverse());
        scanner.close();
    }
}
