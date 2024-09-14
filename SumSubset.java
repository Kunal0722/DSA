import java.util.Scanner;

public class SumSubset {

    // Method to generate a subset corresponding to the binary representation of num
    void subset(int num, int n, int x[]) {
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
        for (int i = n - 1; num != 0; i--) {
            x[i] = num % 2;
            num/=2;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] x = new int[10];
        int n, d, sum;
        boolean present = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the set:");
        n = sc.nextInt();

        System.out.println("Enter the elements of the set:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter the positive integer sum:");
        d = sc.nextInt();

        if (d > 0) {
            SumSubset s = new SumSubset();
            for (int i = 1; i < Math.pow(2, n); i++) {
                s.subset(i, n, x);
                sum = 0;

                for (int j = 0; j < n; j++) {
                    if (x[j] == 1) {
                        sum += a[j];
                    }
                }

                if (d == sum) {
                    System.out.print("Subset = {");
                    present = true;
                    for (int j = 0; j < n; j++) {
                        if (x[j] == 1) {
                            System.out.print(a[j] + " ");
                        }
                    }
                    System.out.println("} = " + d);
                }
            }
        }

        if (!present) {
            System.out.println("Solution does not exist");
        }
    }
}
