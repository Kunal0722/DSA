import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums3 = new int[n];
        int i;

        // Copy nums1 into nums3
        for (i = 0; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }

        // Copy nums2 into nums3
        for (int j = 0; j < nums2.length; j++) {
            nums3[i++] = nums2[j];
        }

        // Sort the merged array
        mergeSort(nums3, 0, n - 1);

        // Find the median
        double median = 0.0;
        if (n % 2 == 0) {
            median = (nums3[n / 2 - 1] + nums3[n / 2]) / 2.0;
        } else {
            median = nums3[n / 2];
        }

        return median;
    }

    // Merge sort function
    void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    // Merge function
    void merge(int[] a, int low, int mid, int high) {
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

    public static void main(String args[]) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array 1 length:");
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];

        System.out.println("Enter Array 2 length:");
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];

        System.out.println("Enter the Array 1 elements:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the Array 2 elements:");
        for (int j = 0; j < n2; j++) {
            arr2[j] = sc.nextInt();
        }

        double median = s.findMedianSortedArrays(arr1, arr2);
        System.out.println("The median is: " + median);
    }
}
