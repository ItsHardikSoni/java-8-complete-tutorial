
import java.util.Scanner;

class PyramidPattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        for (int row = 1; row <= rows; row++) {
            for (int space = 1; space <= rows - row; space++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= 2 * row - 1; column++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
