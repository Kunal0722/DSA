public class NQueenProblem {
    final int N = 4; // size of the chessboard

    // method to print the solution
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    // Method to check if it's safe to place a queen at board[row][col]
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // for checking this row on the left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // for checking the upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // for checking the lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Utility method to solve the N-Queen problem
    boolean solveNQUtil(int board[][], int col) {
        // Base case: If all queens are placed, return true
        if (col >= N)
            return true;

        // Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place the queen

                // Recur to place the rest of the queens
                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0; // BACKTRACK: Remove the queen
            }
        }

        return false; // If the queen cannot be placed in any row, return false
    }

    // Main method to solve the N-Queen problem
    boolean solveNQ() {
        int board[][] = new int[N][N]; // Initialize the board with zeros

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board); // Print the solution
        return true;
    }

    // Main method to run the program
    public static void main(String args[]) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}
