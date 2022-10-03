import java.util.Arrays;
import Interfaces.JustIterable;


interface NewIntArray extends JustIterable{
    void zeros();
}
class IntFixedArray implements NewIntArray {

    int n;
    int[] array;
    IntFixedArray(int n){
        this.n=n;
        array = new int[n];
    }
    

    @Override
    public void set(int n,int ele) {
        array[n]=ele;       
    }

    @Override
    public void delete(int n) {
        array[n]=0;
    }

    @Override
    public void zeros(){
        for(int i=0;i<array.length;i++){
            array[i]=0;
        }
    }
    
    public static void main(String[] args) {
        IntFixedArray arr= new IntFixedArray(5);
        arr.zeros();
        System.out.println(Arrays.toString(arr.array));
        arr.set(3, 10);
        arr.set(2,4);
        System.out.println(Arrays.toString(arr.array));
        arr.delete(3);
        System.out.println(Arrays.toString(arr.array));
        //System.out.println(Double.MAX_VALUE+" "+BigInteger.);

    }
}