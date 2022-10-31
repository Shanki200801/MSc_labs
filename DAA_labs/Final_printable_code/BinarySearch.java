package Final_printable_code;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    private static int binarySearchInternal(int element, int[] array, int min, int max){
        int mid= (min+max)/2;
        if(max>=min){
            if(array[mid]==element){
                return mid;
            }
            if(array[mid]>element){
                max = mid-1;
                return binarySearchInternal(element, array, min, max);
            }
            else{
                min=mid+1;
                return binarySearchInternal(element, array, min, max);
            }          
        }   
        return -1;
    }
    public static void binarySearch(int element, int[] array){
        int min=0;
        int max=array.length-1;
        Arrays.sort(array);
        int pos=binarySearchInternal(element,array, min, max);
        if(pos==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found in position "+pos);
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i =0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched in the array");
        int element=sc.nextInt();

        binarySearch(element, array);
        
    }
    
}
