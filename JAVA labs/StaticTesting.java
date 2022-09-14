import java.util.Scanner;
public class StaticTesting {
    private static String name;
    static Scanner sc = new Scanner(System.in);
    static{
        System.out.println("Entered the static block of static testing class");
    }
    static void display(){
        System.out.println("enter any name");
        name = sc.nextLine();
        System.out.println("The string was scanned using static scanner object and is assigned to static variable");
    }

    static class innerClass{
        static void innerClassMethod(){
            System.out.println(name + " is displayed by inner class static method");
        }
    }
    public static void main(String[] args) {
        display();
        innerClass.innerClassMethod();
    }
}
