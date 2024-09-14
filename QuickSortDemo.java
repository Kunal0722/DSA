import java.util.*;

public class QuickSortDemo {
    static void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    static int partition(int[] a, int b, int r) {
        int pivot = a[r];
        int pindex = b - 1;
        for (int i = b; i < r; i++) {
            if (a[i] <= pivot) {
                pindex++;
                int t = a[i];
                a[i] = a[pindex];
                a[pindex] = t;
            }
        }
        pindex++;
        int t = a[pindex];
        a[pindex] = a[r];
        a[r] = t;
        return pindex;
    }

    static void display(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();  // To move to the next line after printing the array
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = in.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < a.length; i++)
            a[i] = in.nextInt();
        quickSort(a, 0, n - 1);
        System.out.println("Array after sorting the elements:");
        display(a);
    }
}
