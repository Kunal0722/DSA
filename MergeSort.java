import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of elements to be sorted: ");
        int n = in.nextInt();

        int[] a = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(2000);
        }

        System.out.println("Array elements to be sorted are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        long start = System.nanoTime();
        mergeSort(a, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("\nThe sorted elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("The time taken to sort is " + (end - start) + " ns");

        in.close();
    }

    static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    static void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[high - low + 1];
        int h = low, i = 0, j = mid + 1;

        while (h <= mid && j <= high) {
            if (a[h] <= a[j]) {
                b[i++] = a[h++];
            } else {
                b[i++] = a[j++];
            }
        }

        while (h <= mid) {
            b[i++] = a[h++];
        }

        while (j <= high) {
            b[i++] = a[j++];
        }

        System.arraycopy(b, 0, a, low, b.length);
    }
}
