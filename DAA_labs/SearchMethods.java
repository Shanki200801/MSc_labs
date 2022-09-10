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

}