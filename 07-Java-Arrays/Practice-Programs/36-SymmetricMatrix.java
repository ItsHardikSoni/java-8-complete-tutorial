import java.util.Scanner;

class SymmetricMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        boolean symmetric = matrix.length == matrix[0].length;
        if (symmetric) {
            outer:
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != matrix[j][i]) {
                        symmetric = false;
                        break outer;
                    }
                }
            }
        }

        System.out.println(symmetric ? "Matrix is symmetric" : "Matrix is not symmetric");
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
