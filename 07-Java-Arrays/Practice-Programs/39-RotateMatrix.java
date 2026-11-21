import java.util.Scanner;

class RotateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("Matrix must be square");
        } else {
            rotateClockwise(matrix);
            System.out.println("Rotated matrix:");
            printMatrix(matrix);
        }
        scanner.close();
    }

    private static void rotateClockwise(int[][] matrix) {
        int size = matrix.length;
        for (int layer = 0; layer < size / 2; layer++) {
            int first = layer;
            int last = size - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
