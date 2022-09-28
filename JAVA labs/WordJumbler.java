import java.util.Arrays;
import java.util.Scanner;

public class WordJumbler extends Solution {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        WordJumbler obj = new WordJumbler();
        System.out.println("Enter a string");
        String s = sc.nextLine();
        System.out.println(Arrays.toString(obj.jumbleString(s)));
        sc.close();
    
    } 
}
class Solution{
    String[] jumbleString(String s){
        String[] arr = s.split(" ");
        Scanner sc = new Scanner(System.in);
        int[] posarr = new int[arr.length];
        for(int i=0;i<posarr.length;i++){
            System.out.printf("Enter the position of %d th word",i);
            posarr[i]=sc.nextInt();
        }
        String[] newarr = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            newarr[posarr[i]]=arr[i];
        }
        sc.close();

        return newarr;
    }
}