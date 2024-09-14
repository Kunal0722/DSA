import java.util.Scanner;

public class TravellingSalesPerson {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] c = new int[10][10];
        int[] tour = new int[10];
        int i, j, cost;

        System.out.print("Enter No. of Cities: ");
        int n = in.nextInt();

        if (n == 1) {
            System.out.println("Path is not possible");
            System.exit(0);
        }

        System.out.println("Enter the Cost Matrix");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                c[i][j] = in.nextInt();

        for (i = 0; i < n; i++)
            tour[i] = i + 1;

        cost = tspdp(c, tour, 0, n);

        System.out.print("\tThe Optimal Tour is = ");
        for (i = 0; i < n; i++)
            System.out.print(tour[i] + "->");
        System.out.println("1");
        System.out.println("\tMinimum Cost = " + cost);
    }

    static int tspdp(int[][] c, int[] tour, int start, int n) {
        int[] mintour = new int[10], temp = new int[10];
        int mincost = Integer.MAX_VALUE, ccost, i, j, k;

        if (start == n - 2) {
            return (c[tour[n - 2] - 1][tour[n - 1] - 1] + c[tour[n - 1] - 1][0]);
        }

        for (i = start + 1; i < n; i++) {
            for (j = 0; j < n; j++)
                temp[j] = tour[j];

            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];

            if ((c[tour[start] - 1][tour[i] - 1] + (ccost = tspdp(c, temp, start + 1, n))) < mincost) {
                mincost = c[tour[start] - 1][tour[i] - 1] + ccost;
                for (k = 0; k < n; k++)
                    mintour[k] = temp[k];
            }
        }

        for (i = 0; i < n; i++)
            tour[i] = mintour[i];

        return mincost;
    }
}
