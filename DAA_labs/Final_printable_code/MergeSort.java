/*----------------------------------------------------------------
 @Author: Shashank
 Program to perform merge sort on a given unsorted array
 ------------------------------------------------------------------*/
package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("sorted array is " + Arrays.toString(mergeSort(array, 0, array.length - 1)));
    }

    public static int[] mergeSort(int[] unsorted, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            // Divide the entire array into 2 halves and call merge sort on them
            mergeSort(unsorted, beg, mid);
            mergeSort(unsorted, mid + 1, end);
            merge(unsorted, beg, end, mid);
        }
        return unsorted;
    }

    private static void merge(int[] unsorted, int beg, int end, int mid) {
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        int i, j, k = beg;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copying the half of the arrays to 2 new temporary arrays
        for (i = 0; i < n1; i++)
            leftArray[i] = unsorted[beg + i];
        for (j = 0; j < n2; j++)
            rightArray[j] = unsorted[mid + j + 1];

        i = 0;
        j = 0;

        // comparing the left and right array and adding in order
        while (i < n1 && j < n2) {
            // count++;//to keep track of each comparisions
            if (leftArray[i] <= rightArray[j]) {
                unsorted[k] = leftArray[i];
                i++;
            } else {
                unsorted[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // happens after either left or the right array runs
        // out and the remaining of the 2 are added
        while (i < n1) {
            unsorted[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            unsorted[k] = rightArray[j];
            j++;
            k++;
        }

    }
}
