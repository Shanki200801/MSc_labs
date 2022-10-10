import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class InbuiltMethods {
    public static void main(String[] args) {
        String str = new String();

        ArrayList<Integer> arr = new ArrayList<>();
        int[] arrs = new int[10];

        StringBuilder bstr = new StringBuilder();
        str = "hello darkness my old friend";

        System.out.println(arr.add(5));

        Collections.sort(arr);
        Arrays.sort(arrs);
        
        bstr.append(str);
        bstr.reverse();

        if(str.indexOf('c')==-1){
            //statements
        }
        
        String[] array = new String[100];
        array = str.split(" ");

        System.out.println(Arrays.toString(array));

    }
}
