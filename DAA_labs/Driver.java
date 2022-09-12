import java.util.*;
public class Driver {
    public static void main(String[] args){

        int[] array = inputArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be searched in the array");
        int element=sc.nextInt();

        //display(SortMethods.bubbleSort(array));
        //display(SortMethods.insertionSort(array));
        //display(SortMethods.selectionSort(array));
        //display(SortMethods.mergeSort(array,0,array.length-1));
        //System.out.println(SortMethods.count);
        //display(SortMethods.quickSort(array,0,array.length-1));

        SearchMethods.linearSearch(element, array,true);
        //SearchMethods.binarySearch(element, array);
    }

    private static int[] inputArray() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of element in array");
        int n= sc.nextInt();
        System.out.println("Enter "+n+" elements of array");
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        return array;
    }
    
    private static void display(int[] sorted) {
        System.out.println("Sorted array is " + Arrays.toString(sorted));
    }
}
