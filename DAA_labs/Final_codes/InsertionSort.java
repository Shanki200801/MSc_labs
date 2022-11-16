/*----------------------------------------------------------------
 @Author: Shashank
 Program to sort a given array in ascending order using
 insertion sort algorithm
 ------------------------------------------------------------------*/
package Final_codes;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // input of the array
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        // function call and printing the array
        System.out.println("sorted array is " + Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] array) {
        System.out.println("Using insertion sort to sort the array .. ");
        // starting from 2nd element as we assume 1st is sorted
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return (array);
    }
}
