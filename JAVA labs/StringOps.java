import java.util.Scanner;

public class StringOps {
    
    static String concatString(String s1, String s2){
        return s1.concat(s2);
    }

    static int[] countVowels(String str){
        int[] arr = {0,0,0,0,0};
        for(int i =0;i<str.length();i++){
            switch(str.toLowerCase().charAt(i)){
                case 'a': arr[0]++;
                break;
                case 'e': arr[1]++;
                break;
                case 'i': arr[2]++;
                break;
                case 'o': arr[3]++;
                break;
                case 'u': arr[4]++;
            }          
        }
        return arr;
    }

    static String trimString(String str, int n){
        return(str.substring(0,str.length()-n));
    }

    static int returnPos(String str, char c){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter 2 strings");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println("Concatinated string is "+ concatString(s1, s2));

        System.out.println("Enter the number of elements to be trimmed from the end of the string 1");
        int n= sc.nextInt();
        System.out.println("The trimmed string 1 is "+trimString(s1, n));

        System.out.println("The counts for the vowels in String 1 are as follows");
        int[] arr  = countVowels(s1);
        System.out.println("The number of a's are "+arr[0]);
        System.out.println("The number of e's are "+arr[1]);
        System.out.println("The number of i's are "+arr[2]);
        System.out.println("The number of o's are "+arr[3]);
        System.out.println("The number of u's are "+arr[4]);

        System.out.println("Enter the character to look for in the string");
        char c=sc.next().charAt(0);
        int pos = returnPos(s1, c);
        if(pos!=-1){
            System.out.println("Element found in position "+pos);
        }

    }
    
}