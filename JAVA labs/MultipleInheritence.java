interface myInterface{
    public void display(int[] arr);
}

class myClass{
    int smallest(int[] arr){
        return -1;
    }
    int largest(int[] arr){
        return -1;
    }
}
public class MultipleInheritence extends myClass implements myInterface{
    int smallest(int [] arr){
        int min = arr[0];
        for(int x:arr){
            if(x<min)
                min=x;
        }
        return min;
    }
    int largest(int [] arr){
        int max = arr[0];
        for(int x:arr){
            if(x>max)
                max=x;
        }
        return max;
    }
    public void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.printf("%d ",arr[i]);
        }
        System.out.println();
    }
    public void display(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.printf("%d ",arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter an array");
        //input array
        //call those methods and display smallest and largest
    }
}