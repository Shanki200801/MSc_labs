/*----------------------------------------------------------------
 @Author: Shashank
 Program to sort the given array in ascending order
 using bubble sort
 ------------------------------------------------------------------*/
package Final_codes;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static int[] bubbleSort(int[] unsorted) {
        System.out.println("Using bubble sort");
        for (int i = 0; i < unsorted.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < unsorted.length - 1 - i; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    int t = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = t;
                    swapped = true;
                }
            }
            // if the swap did not take place the array is already sorted
            // hence we can break out of the loop to not do unnecessary computation
            if (!swapped) {
                break;
            }
        }
        return (unsorted);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // input the array
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        // printing the sorted array
        System.out.println("sorted array is " + Arrays.toString(bubbleSort(array)));
    }
}
