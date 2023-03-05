package sorting;
import java.util.*;
/**
 * @author Satyam Singh
 * Time complexity : Best case              Worst case
 *                    O(nlog*n)              O(nlog*n)
 * Space : O(n)
 * @Stable
 * @No_in_place
 */
public class MergeSort {
	static void merge(int arr[], int low, int mid, int high)
    {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];
        
        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0;
        int k = low;
        
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    static void mergeSort(int arr[], int low, int high)
    {
        if (low < high) {
            // Find the middle point
            int mid =low+ (high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int n =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextInt();
        
        mergeSort(arr, 0, n-1);

        int count = 0;
        System.out.println(Integer.toString(count).getClass());
        System.out.println("Sorted array");
        printArray(arr);
    }

}
