package Final_printable_code;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {

    public static void linearSearch(int element, int[] array){
        boolean flag=false;
        for(int i=0;i<array.length;i++){
            if(element==array[i]){
                flag=true;
                System.out.println("Element found in the index "+i);
                break;
            }
        }
        if(flag==false) System.out.println("element not found");
        
    }
    //method overload for multi-linear search
    public static void linearSearch(int element, int[] array, boolean multiple){
        if(multiple){
            ArrayList<Integer> newArr = new ArrayList<>();
            for(int i=0;i<array.length;i++){
                if(element==array[i]){
                    newArr.add(i);
                }
            }
            if(newArr.isEmpty())
                System.out.println("element not found");
            else 
                System.out.println("element found in");
                System.out.println(newArr.toString());
            
        }
        else{
            linearSearch(element, array);
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

        linearSearch(element, array);
        
    }
}
