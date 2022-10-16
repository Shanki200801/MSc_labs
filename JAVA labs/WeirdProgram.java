import java.util.HashMap;
import java.util.Scanner;

interface solInter{
    boolean isPalindrome(String s);
    String numToString(int n);
    String romanToString(String str);
}

public class WeirdProgram implements solInter{
    HashMap<Integer,String> hm1 = new HashMap<>();
    HashMap<String,String> hm2 = new HashMap<>();
    @Override
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        str.reverse();
        String s2 = str.toString();
        if(s.equals(s2)){
            return true;
        }
        return false;
    }
    @Override
    public String numToString(int n) {
        if(n>10){
            System.out.println("Invalid number");
            return " ";
        }
        hm1.put(1, "one");
        hm1.put(2,"two");
        hm1.put(3,"three");
        hm1.put(4,"four");
        hm1.put(5,"five");
        hm1.put(6,"six");
        hm1.put(7,"Seven");
        hm1.put(8,"Eight");
        hm1.put(9,"nine");
        hm1.put(10,"ten");
        return hm1.get(n);
    }
    @Override
    public String romanToString(String str) {
        hm2.put("I","one");
        hm2.put("II","two");
        hm2.put("III","three");
        hm2.put("IV","four");
        hm2.put("V","five");
        hm2.put("VI","six");
        hm2.put("VII","Seven");
        hm2.put("VIII","Eight");
        hm2.put("IX","nine");
        hm2.put("X","ten");
        if(hm2.containsKey(str))
            return hm2.get(str);
        System.out.println("Invalid string");
        return " ";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeirdProgram obj = new WeirdProgram();
        System.out.println("Enter a number to convert to string");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println(n+ " --> "+ obj.numToString(n));
        System.out.println("Enter roman number to convert to string");
        String roman = sc.nextLine();
        System.out.println(roman+ " --> "+obj.romanToString(roman));
        System.out.println("Enter number of strings to check for palindrome");
        int num = sc.nextInt();
        sc.nextLine();
        String[] arr =new String[num];
        for(int i =0;i<num;i++){
            arr[i]=sc.nextLine();
            if(obj.isPalindrome(arr[i]))
                System.out.println("palindrome");
            else
                System.out.println("not palindrome");
        }
        
    }
    
}
