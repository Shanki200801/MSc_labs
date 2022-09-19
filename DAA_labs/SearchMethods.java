import java.util.ArrayList;

public class SearchMethods{

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
        int[] new_array = SortMethods.insertionSort(array);
        int pos=binarySearchInternal(element,new_array, min, max);
        if(pos==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found in position "+pos);
        }
    }

    public static int[] minMaxSearch(int [] array, int min, int max){
        int i= min, j=max;
        int[] minmax_array = new int[2];
        if(i==j){
            minmax_array[0]=array[i];
            minmax_array[1]=array[i];
            return minmax_array;
        }
        else if(i==j-1){
            if(array[i]<array[j]){
                minmax_array[0]=array[i];
                minmax_array[1]=array[j];
            }
            else{
                minmax_array[1]=array[i];
                minmax_array[0]=array[j];
            }
            return minmax_array;
        }
        
            int mid= (min + max)/2;
            int[] left_minmax = minMaxSearch(array, min, mid);
            int[] right_minmax = minMaxSearch(array, mid+1, max);

            if(left_minmax[0]<right_minmax[0])
                minmax_array[0]=left_minmax[0];
            else
                minmax_array[0]=right_minmax[0];

            if(left_minmax[1]>right_minmax[1])
                minmax_array[1]=left_minmax[1];
            else
                minmax_array[1]=right_minmax[1];

            return minmax_array;

        

    }
}