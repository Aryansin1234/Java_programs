import java.util.Scanner;
public class ReverseDiagonalElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Dynamically create the 2D matrix
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        reverseDiagonalElements(matrix);

        System.out.println("Matrix after reversing both diagonal elements:");
        printMatrix(matrix);
        scanner.close();
    }

    private static void reverseDiagonalElements(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            // For major diagonal
            int temp = matrix[i][i];
            matrix[i][i] = matrix[n - i - 1][n - i - 1];
            matrix[n - i - 1][n - i - 1] = temp;

            // For minor diagonal
            temp = matrix[i][n - 1 - i];
            matrix[i][n - 1 - i] = matrix[n - 1 - i][i];
            matrix[n - 1 - i][i] = temp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " \t"); // Add space and tab for alignment
            }
            System.out.println(); // Add line break after each row
        }
    }
}

