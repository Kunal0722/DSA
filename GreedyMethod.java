import java.util.Scanner;
public class GreedyMethod {
    public static void main(String[] args) {
        int i, j = 0, max_qty, n;
        float totalProfit = 0, maxRatio;
        Scanner sc = new Scanner(System.in);
        int array[][] = new int[2][20]; // First row for weights, second row for values
        System.out.println("Enter the number of items:");
        n = sc.nextInt();
        System.out.println("Enter the weights of each item:");
        for (i = 0; i < n; i++)
            array[0][i] = sc.nextInt();
        System.out.println("Enter the values of each item:");
        for (i = 0; i < n; i++)
            array[1][i] = sc.nextInt();
        System.out.println("Enter the maximum volume of the knapsack:");
        max_qty = sc.nextInt();
        int remainingCapacity = max_qty;
        while (remainingCapacity > 0) {
            maxRatio = 0;
            // Find the item with the highest value-to-weight ratio that hasn't been fully used
            for (i = 0; i < n; i++) {
                if (array[0][i] > 0) { // Ensure the item is still available
                    float currentRatio = (float) array[1][i] / array[0][i];
                    if (currentRatio > maxRatio) {
                        maxRatio = currentRatio;
                        j = i;
                    }
                }
            }

            if (array[0][j] > remainingCapacity) {
                System.out.println("Quantity of item " + (j + 1) + " added: " + remainingCapacity);
                totalProfit += remainingCapacity * maxRatio;
                break; // Knapsack is full
            } else {
                System.out.println("Quantity of item " + (j + 1) + " added: " + array[0][j]);
                remainingCapacity -= array[0][j];
                totalProfit += array[1][j];
                array[0][j] = 0; // Mark this item as fully used
            }
        }

        System.out.println("The total profit is: " + totalProfit);
        sc.close();
    }
}
