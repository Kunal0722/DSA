import java.util.Scanner;

public class FloydWarshall {

    // Method to apply the Floyd-Warshall algorithm
    void floydWarshall(int[][] w, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();

        int[][] a = new int[n][n];  // Initialize the matrix with dynamic size based on user input

        System.out.println("Enter the weighted matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        FloydWarshall f = new FloydWarshall();
        f.floydWarshall(a, n);

        System.out.println("The shortest path matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
