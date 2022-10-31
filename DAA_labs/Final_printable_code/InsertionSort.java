package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("sorted array is " + Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] unsorted) {
        System.out.println("Using insertion sort to sort the array .. ");       
        for(int i=1;i<unsorted.length;i++){
            int key= unsorted[i];
            int j= i-1;
            while(j>=0 && key<unsorted[j]){
                unsorted[j+1]=unsorted[j];
                j--;
            }
            unsorted[j+1]=key;
        }
        return(unsorted);
    }
}
