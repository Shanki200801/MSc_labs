/*-----------------------------------------------------------
Program to Demonstarte user-defined packages 
and perform selection sort
@Author - Shashank
-------------------------------------------------------------*/

package Printable_java;

import java.util.Arrays;
import java.util.Scanner;

import Printable_java.Work.*;;

public class SelectionDriver {
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter the size of the array to be inputted:");
        int size = scan.nextInt();
        System.out.println("\nEnter the elements of the array:");
        int[] array = new int[size];
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }

        System.out.println("\nThe array you inputted is:");
        System.out.println(Arrays.toString(array));

        array = obj.selectionSort(array);
        System.out.println("Sorted array is " + Arrays.toString(array));
    }
}
