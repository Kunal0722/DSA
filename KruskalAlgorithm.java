import java.util.Scanner;

public class KruskalAlgorithm {
    
    int[] parent;
    
    public KruskalAlgorithm(int n) {
        parent = new int[n];
    }

    int find(int m) {
        if (parent[m] == 0) {
            return m;
        } else {
            parent[m] = find(parent[m]); // Path compression
            return parent[m];
        }
    }

    void union(int i, int j) {
        parent[i] = j; // Union by rank can be added here if needed
    }

    void kruskal(int[][] a, int n) {
        int u = 0, v = 0, min, k = 0, sum = 0;

        while (k < n - 1) {
            min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] < min && i != j) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            int i = find(u);
            int j = find(v);

            if (i != j) {
                union(i, j);
                System.out.println("(" + (u + 1) + "," + (v + 1) + ") = " + a[u][v]);
                sum += a[u][v];
                k++;
            }

            a[u][v] = a[v][u] = Integer.MAX_VALUE; // Mark edge as used
        }

        System.out.println("The cost of the minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices of the graph:");
        int n = sc.nextInt();

        int[][] a = new int[n][n];

        System.out.println("Enter the weighted matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        KruskalAlgorithm k = new KruskalAlgorithm(n);
        k.kruskal(a, n);

        sc.close();
    }
}
