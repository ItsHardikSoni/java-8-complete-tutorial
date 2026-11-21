import java.util.Scanner;

class MatrixTranspose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose:");
        printMatrix(transpose);
        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner) {
        System.out.print("Enter rows and columns: ");
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
