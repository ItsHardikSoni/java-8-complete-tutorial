import java.util.Scanner;

class NumberFormatException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println("Number: " + number);
        } catch (java.lang.NumberFormatException exception) {
            System.out.println("Invalid integer format.");
        }
        scanner.close();
    }
}
