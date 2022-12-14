import java.util.*;
public class SortMethods{
    static int count = 0; 
    public static int[] mergeSort(int[] unsorted, int beg, int end) {
        if(beg<end){           
            int mid = (beg+end)/2;
            //Divide the entire array into 2 halves and call merge sort on them
            mergeSort(unsorted, beg, mid);
            mergeSort(unsorted, mid+1, end);
            merge(unsorted,beg,end,mid);           
        }
        return unsorted;
    }  
    private static void merge(int[] unsorted, int beg, int end, int mid) {
        int n1= mid- beg +1;
        int n2= end - mid;
        int i,j,k=beg;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //Copying the half of the arrays to 2 new temporary arrays
        for( i=0;i<n1;i++)
            leftArray[i]=unsorted[beg+i];
        for( j=0;j<n2;j++)
            rightArray[j]=unsorted[mid+j+1];

        i=0;j=0;

        //comparing the left and right array and adding in order
        while(i<n1&&j<n2){            
            count++;//to keep track of each comparisions
            if(leftArray[i]<=rightArray[j]){
                unsorted[k]=leftArray[i];
                i++;                 
            }
            else{
                unsorted[k]=rightArray[j];
                j++;                          
            }
            k++;
        }

        //happens after either left or the right array runs 
        //out and the remaining of the 2 are added
        while(i<n1){
            unsorted[k]=leftArray[i];
            i++; k++;
        }
        while(j<n2){
            unsorted[k]=rightArray[j];
            j++; k++;
        }
        
    }
    //takes last element as the pivot
    public static int[] quickSort(int[] unsorted,int low, int high) {
       if(low<high){
        int p = partition(unsorted, low, high);
        quickSort(unsorted, low, p-1);
        quickSort(unsorted, p+1, high);
        }
        return unsorted;
    }
    private static int partition(int[] unsorted, int low, int high){
        int pivot = unsorted[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(unsorted[j]<pivot){
                i++;
                int t=unsorted[j];
                unsorted[j]=unsorted[i];
                unsorted[i]=t;
            }
        }
        int t=unsorted[i+1];
        unsorted[i+1]=unsorted[high];
        unsorted[high]=t;
        return (i+1);
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
    
    //takes first element as the pivot and implements algo done in class
    public static int[] quickSort2(int[] unsorted, int low, int high){
        if(low<high){
        int p= partition2(unsorted, low, high);
        quickSort2(unsorted, low, p-1);
        quickSort2(unsorted, p+1, high);
        }
        return unsorted;
    }
    private static int partition2(int[] unsorted,int low,int high){
        int  i=low,j=high;
        
        int index = unsorted[low];
        while(i<j){
            while(unsorted[i]<index && i<high ){
                i++;
            }
            while(unsorted[j]>index && j>=low){
                j--;
            }
            if(i<j){
                int temp = unsorted[i];
                unsorted[i]=unsorted[j];
                unsorted[j]=temp;
            }
        }
        
            int temp2=unsorted[j];
            unsorted[j]=index;
            index=temp2;
        

        
        return j;
    }
}