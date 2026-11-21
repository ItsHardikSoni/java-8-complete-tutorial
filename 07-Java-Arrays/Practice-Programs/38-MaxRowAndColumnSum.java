import java.util.Scanner;

class MaxRowAndColumnSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        if (matrix.length == 0) {
            System.out.println("Matrix is empty");
        } else {
            int maxRow = 0;
            int maxRowSum = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                int rowSum = 0;
                for (int value : matrix[i]) {
                    rowSum += value;
                }
                if (rowSum > maxRowSum) {
                    maxRowSum = rowSum;
                    maxRow = i;
                }
            }

            int maxColumn = 0;
            int maxColumnSum = Integer.MIN_VALUE;
            int columns = matrix[0].length;
            for (int j = 0; j < columns; j++) {
                int columnSum = 0;
                for (int i = 0; i < matrix.length; i++) {
                    columnSum += matrix[i][j];
                }
                if (columnSum > maxColumnSum) {
                    maxColumnSum = columnSum;
                    maxColumn = j;
                }
            }

            System.out.println("Row with maximum sum: " + maxRow + " (sum " + maxRowSum + ")");
            System.out.println("Column with maximum sum: " + maxColumn + " (sum " + maxColumnSum + ")");
        }
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
}
