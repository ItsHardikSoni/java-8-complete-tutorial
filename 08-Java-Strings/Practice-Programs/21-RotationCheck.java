import java.util.Scanner;

class RotationCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String first = scanner.nextLine();
        System.out.print("Enter second String: ");
        String second = scanner.nextLine();
        boolean rotation = first.length() == second.length() && first.length() > 0;
        if (rotation) {
            rotation = (first + first).contains(second);
        }
        System.out.println(rotation ? "Strings are rotations" : "Strings are not rotations");
        scanner.close();
    }
}
