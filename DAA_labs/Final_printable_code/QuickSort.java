package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("sorted array is " + Arrays.toString(quickSort2(array, 0, array.length - 1)));
    }

    public static int[] quickSort2(int[] unsorted, int low, int high) {
        if (low < high) {
            int p = partition2(unsorted, low, high);
            quickSort2(unsorted, low, p - 1);
            quickSort2(unsorted, p + 1, high);
        }
        return unsorted;
    }

    private static int partition2(int[] unsorted, int low, int high) {
        int i = low, j = high;

        int index = unsorted[low];
        while (i < j) {
            while (unsorted[i] < index && i < high) {
                i++;
            }
            while (unsorted[j] > index && j >= low) {
                j--;
            }
            if (i < j) {
                int temp = unsorted[i];
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;
            }
        }
        int temp2 = unsorted[j];
        unsorted[j] = index;
        index = temp2;
        return j;
    }
}
