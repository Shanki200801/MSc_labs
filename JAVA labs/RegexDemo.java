import java.util.Scanner; 
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDemo {
    public static void main(String[] args) {
        
        String regex = "..\2\1";
        String text = "boot";

        Pattern pt = Pattern.compile(regex);   
        Matcher mt = pt.matcher(text); 
        
        boolean result = mt.matches();
        boolean result2 = Pattern.matches("^[a-zA-Z]$|.*\1$","helloh");
        
        System.out.println(result2);
       // System.out.println(result);
    }
}
