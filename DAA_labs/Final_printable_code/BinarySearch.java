/*----------------------------------------------------------------
 @Author: Shashank
 Program to search for a given element in the array
 using binary seach which uses divide and conquor method
 ------------------------------------------------------------------*/

package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    private static int binarySearchInternal(int element, int[] array, int min, int max) {
        int mid = (min + max) / 2;
        // when the problem is not small
        if (max >= min) {
            if (array[mid] == element) {
                return mid;
            }
            // when the element is in the 1st half
            if (array[mid] > element) {
                max = mid - 1;
                return binarySearchInternal(element, array, min, max);
            }
            // when the element is in the second half
            else {
                min = mid + 1;
                return binarySearchInternal(element, array, min, max);
            }
        }
        // when element is not found
        return -1;
    }

    public static void binarySearch(int element, int[] array) {
        int min = 0;
        int max = array.length - 1;
        // binary search only works on sorted arrays so..
        Arrays.sort(array);
        int pos = binarySearchInternal(element, array, min, max);
        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found in position " + pos);
        }
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
        System.out.println("Enter the element to be searched in the array");
        int element = sc.nextInt();
        binarySearch(element, array);
    }
}
