/*-----------------------------------------------------------
Program to demonstrate parent method calls using super keyword
@Author - Shashank
-------------------------------------------------------------*/

package Final_codes;

import java.util.Arrays;
import java.util.Scanner;

class Parent {
    public int binarySearch(int[] arr, int element) {
        int pos = Arrays.binarySearch(arr, element);
        return pos;
    }
}

class Child extends Parent {
    public int binarySearch(int[] arr, int element) {
        int pos = super.binarySearch(arr, element);
        System.out.println("Element found in " + pos);
        return pos;
    }
}

public class SuperOverride {
    public static void main(String[] args) {
        Child obj = new Child();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter " + n + " elements");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the number to be searched");
        int element = sc.nextInt();
        obj.binarySearch(array, element);
    }
}
