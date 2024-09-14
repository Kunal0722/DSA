import java.util.Scanner;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int[][] w = new int[11][11]; // Increase size to accommodate 1-based indexing
        int n, i, j, s, k;
        int min;
        int sum = 0;
        int u = 0, v = 0;
        int flag = 0;
        int[] sol = new int[11]; // Increase size to accommodate 1-based indexing
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices:");
        n = sc.nextInt();
        
        for (i = 1; i <= n; i++) {
            sol[i] = 0;
        }
        
        System.out.println("Enter the weighted graph:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Enter the source vertex:");
        s = sc.nextInt();
        sol[s] = 1;
        k = 1;
        
        while (k <= n - 1) {
            min = 99; // Large value as a placeholder for minimum
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (sol[i] == 1 && sol[j] == 0 && i != j && min > w[i][j] && w[i][j] != 0) {
                        min = w[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            sol[v] = 1;
            sum += min;
            k++;
            System.out.println(u + " -> " + v + " = " + min);
        }
        
        for (i = 1; i <= n; i++) {
            if (sol[i] == 0) {
                flag = 1;
                break;
            }
        }
        
        if (flag == 1) {
            System.out.println("No spanning tree");
        } else {
            System.out.println("The cost of the minimum spanning tree is " + sum);
        }
        
        sc.close();
    }
}
