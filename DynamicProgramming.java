import java.util.Scanner;

public class DynamicProgramming {
    // Function to return the maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // Function to solve the knapsack problem using dynamic programming
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        // Create a 2D array to store the maximum value that can be obtained with a given weight
        int[][] K = new int[n + 1][W + 1];
        // Build the table K[][] in bottom-up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                // Base case: if no items or capacity is zero
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }
                // If weight of the current item is less than or equal to the current capacity
                else if (wt[i - 1] <= w) {
                    // Choose the maximum between including the item or not including it
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    // If the item cannot be included, carry over the value from the previous item
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        // The maximum value that can be obtained with the given capacity
        return K[n][W];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.println("Enter the item weights: ");
        int[] wt = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        System.out.println("Enter the item values: ");
        int[] val = new int[n];
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        System.out.println("Enter the maximum capacity of the knapsack: ");
        int W = sc.nextInt();
        // Calculate and print the maximum value that can be put in a knapsack of capacity W
        System.out.println("The maximum value that can be put in a knapsack of capacity " + W + " is: " +
                knapSack(W, wt, val, n));
        sc.close();
    }
}
