import java.util.Scanner;
public class InsertionSort {
    // Function to sort an array using insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Utility function to print an array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method to test the insertion sort
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int z=sc.nextInt();
        int arr[]=new int[z];
        
        for (int i = 0; i<z; i++)
        {
            if((i+1)%10==1)
            System.out.println("Enter the "+(i+1)+"st element:");
            else if((i+1)%10==2)
            System.out.println("Enter the "+(i+1)+"nd element:");
            else if((i+1)%10==3)
            System.out.println("Enter the "+(i+1)+"rd element:");
            else if((i+1)==11 || (i+1)==12 || (i+1)==13 || (i+1)%10>3)
            System.out.println("Enter the "+(i+1)+"th element:");
            arr[i]=sc.nextInt();
        }
        System.out.println("Unsorted array:");
        printArray(arr);
        
        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
