import java.util.*;
public class SortMethods{
   
    public static int[] mergeSort(int[] unsorted) {
        return unsorted;
    }

    public static int[] quickSort(int[] unsorted) {
        return unsorted;
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

    public static int[] bubbleSort(int[] unsorted) {
        System.out.println("Using bubble sort");
        for(int i=0;i<unsorted.length;i++){
            boolean swapeed = false;
            for(int j=0;j<unsorted.length-1-i;j++){
                if(unsorted[j]>unsorted[j+1]){
                    int t=unsorted[j];
                    unsorted[j]=unsorted[j+1];
                    unsorted[j+1]=t;
                    swapeed=true;
                }             
            }
            if(!swapeed){break;}
        }
        return(unsorted);        
    }

    public static void display(int[] sorted) {
        System.out.println("Sorted array is " + Arrays.toString(sorted));
    }
}