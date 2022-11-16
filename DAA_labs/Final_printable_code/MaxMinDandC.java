/*----------------------------------------------------------------
 @Author: Shashank
 Program to find the maximum and the minimum of a given array using divide
 and conquor technique for a given matrix
 ------------------------------------------------------------------*/
package Final_printable_code;

import java.util.Scanner;

public class MaxMinDandC {

    public static int[] minMaxSearch(int[] array, int min, int max) {
        int i = min, j = max;
        // The array contains local minimum at position 0 and local maximum at position
        // 1
        int[] minmax_array = new int[2];

        // if its a small problem of length 1
        if (i == j) {
            minmax_array[0] = array[i];
            minmax_array[1] = array[i];
            return minmax_array;
        }

        // if its a small problem of length 2
        if (i == j - 1) {
            if (array[i] < array[j]) {
                minmax_array[0] = array[i];
                minmax_array[1] = array[j];
            } else {
                minmax_array[1] = array[i];
                minmax_array[0] = array[j];
            }
            return minmax_array;
        }
        // if its not a small problem then use the divide and conquor method
        int mid = (min + max) / 2;
        int[] left_minmax = minMaxSearch(array, min, mid);
        int[] right_minmax = minMaxSearch(array, mid + 1, max);

        if (left_minmax[0] < right_minmax[0])
            minmax_array[0] = left_minmax[0];
        else
            minmax_array[0] = right_minmax[0];

        if (left_minmax[1] > right_minmax[1])
            minmax_array[1] = left_minmax[1];
        else
            minmax_array[1] = right_minmax[1];

        return minmax_array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter all the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] mmarr = new int[2];
        mmarr = minMaxSearch(array, 0, array.length - 1);

        System.out.println("Minimum of the array is " + mmarr[0]);
        System.out.println("Maximum of the array is " + mmarr[1]);
    }
}
