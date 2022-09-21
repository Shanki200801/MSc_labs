import java.util.Arrays;

class IntegerArray{
    int size;
    int end_pointer=0;   
    IntegerArray(int size){
        this.size=size;
    }
    protected int[] array = new int[size];

    public void put(int ele){
        array[end_pointer]=ele;
        end_pointer++;
    }

    public void delete(int pos){
        end_pointer--;
    }

    public void display(){
        System.out.println(Arrays.toString(array));
    }
}

public class ArrayClass_AccessModifiers {
    public static void main(String[] args) {
        IntegerArray newArray= new IntegerArray(10);

    }
}
