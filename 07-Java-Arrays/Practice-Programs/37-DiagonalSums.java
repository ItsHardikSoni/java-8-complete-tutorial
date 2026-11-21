import java.util.Scanner;

class DiagonalSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("Matrix must be square");
        } else {
            int primary = 0;
            int secondary = 0;
            for (int i = 0; i < matrix.length; i++) {
                primary += matrix[i][i];
                secondary += matrix[i][matrix.length - i - 1];
            }
            System.out.println("Primary diagonal sum: " + primary);
            System.out.println("Secondary diagonal sum: " + secondary);
        }
        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner) {
        System.out.print("Enter square matrix size: ");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
