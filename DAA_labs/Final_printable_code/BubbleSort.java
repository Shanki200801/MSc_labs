package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static int[] bubbleSort(int[] unsorted) {
        System.out.println("Using bubble sort");
        for (int i = 0; i < unsorted.length; i++) {
            boolean swapeed = false;
            for (int j = 0; j < unsorted.length - 1 - i; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    int t = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = t;
                    swapeed = true;
                }
            }
            if (!swapeed) {
                break;
            }
        }
        return (unsorted);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("sorted array is " + Arrays.toString(array));
    }
}
