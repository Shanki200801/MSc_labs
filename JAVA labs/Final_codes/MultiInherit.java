/*-----------------------------------------------------------
Program to demonstrate multi level inheritence using interfaces
@Author - Shashank
-------------------------------------------------------------*/
package Final_codes;

import java.util.Scanner;

interface myInterface {
    public void display(int[] arr);
}

class myClass {
    int smallest(int[] arr) {
        return -1;
    }

    int largest(int[] arr) {
        return -1;
    }
}

public class MultiInherit extends myClass implements myInterface {
    int smallest(int[] arr) {
        int min = arr[0];
        for (int x : arr) {
            if (x < min)
                min = x;
        }
        return min;
    }

    int largest(int[] arr) {
        int max = arr[0];
        for (int x : arr) {
            if (x > max)
                max = x;
        }
        return max;
    }

    public void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MultiInherit obj = new MultiInherit();

        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("The smallest number in array is " + obj.smallest(array));
        System.out.println("The largest number in array is " + obj.largest(array));

        // input array
        // call those methods and display smallest and largest
    }
}