
public class MethodOverloading{

    public static void Combine(int... arr){
        int sum=0;
        for(int ele: arr){
            sum+=ele;
        }
        System.out.println("Sum is equal to "+sum);
    }
    public static void Combine(String... arr){
        String concatString = new String();
        for(String ele: arr){
            concatString+=ele;
        }
        System.out.println("Concatinated string is "+concatString);
    }
     
    public static void main(String[] args){ 
        Combine(3,5,7,8,2,6 ,8 ,4 ,2 ,1 ,3 ,5,7 ,8 ,8 , 9,9 );
        Combine("Array1","array2","lastarray");
    }
}
