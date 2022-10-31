package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("sorted array is " + Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] unsorted) {
        System.out.println("Using selection sort");
        for(int i=0;i<unsorted.length;i++){
            int min_index=i;
            for(int j=i+1;j<unsorted.length;j++){
                if(unsorted[min_index]>unsorted[j]){
                    min_index=j;
                }
            }
            int t=unsorted[i];
            unsorted[i]=unsorted[min_index];
            unsorted[min_index]=t;
        }
        return(unsorted);
    }
}
