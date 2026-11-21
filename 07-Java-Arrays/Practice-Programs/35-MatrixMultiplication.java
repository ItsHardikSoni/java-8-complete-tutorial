import java.util.Scanner;

class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] first = readMatrix(scanner, "first");
        int[][] second = readMatrix(scanner, "second");

        if (first.length == 0 || first[0].length != second.length) {
            System.out.println("Matrix multiplication is not possible");
        } else {
            int[][] result = new int[first.length][second[0].length];
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second[0].length; j++) {
                    for (int k = 0; k < second.length; k++) {
                        result[i][j] += first[i][k] * second[k][j];
                    }
                }
            }
            System.out.println("Product:");
            printMatrix(result);
        }
        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner, String name) {
        System.out.print("Enter rows and columns for " + name + " matrix: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
