
import java.util.Scanner;

class SquarePattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter square size: ");
        int size = scanner.nextInt();

        for (int row = 1; row <= size; row++) {
            for (int column = 1; column <= size; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
