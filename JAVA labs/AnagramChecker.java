import java.util.Scanner;

public class AnagramChecker {
    static boolean AnagramCheck(String s1,String s2){
        boolean flag=true;
        s1=s1.toLowerCase(); s2=s2.toLowerCase();

        for(int i=0;i<s1.length();i++){
            int pos =s2.indexOf(s1.charAt(i));
            if(pos<0)
                flag=false;               
        }
        for(int i=0;i<s2.length();i++){
            int pos =s1.indexOf(s2.charAt(i)) ;
            if(pos<0)
                flag=false;                
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 2 strings");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(AnagramCheck(s1, s2))
            System.out.println("The given Strings are anagrams");
        else
            System.out.println("The given strings arent anagarams");
    }
}
