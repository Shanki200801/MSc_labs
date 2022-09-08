
public class MethodOverloading{

    public static void Combine(String s1, String s2){
        System.out.println(s1+s2);
    }
    public static void Combine(int s1, int s2){
        int sum= s1+s2;
        System.out.println("sum = "+ sum);
    }
    public static void main(String[] args){
        Combine("hello", "worlds");
        Combine(5, 43);
    }
}