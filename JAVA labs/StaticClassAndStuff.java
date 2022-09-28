import java.util.Scanner;
class Character2 {
    
    static{
        System.out.println("This is a program to demonstrate static blocks, mathods and variables");
    }

    static String name;

    static void searchScream(){
        for(int i=0;i<4;i++)
            System.out.println("HEYYYYYYY "+ name.toUpperCase()+"! WHERE ARE YOU!!?");
    }

    static void getName(){
        System.out.println("Hello traveller what's your name?");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
    }

    static class Pets{
        String kind, name;
        int age;

        void action(){

            System.out.println(this.name+" says");
            if(this.kind.toLowerCase()=="dragon"){System.out.println("RAWWWWRRRR");}
            else if(this.kind.toLowerCase()=="aquatic"){System.out.println("Splash splash");}
            else{System.out.println("wags tail");}
        }
    }
}

/**
 * StaticClassAndStuff
 */
public class StaticClassAndStuff {
    public static void main(String[] args) {
        Character2 ch1 = new Character2();
        Character2.getName();
        Character2.searchScream();

        Character2.Pets newPet = new Character2.Pets();
        newPet.age =5;
        newPet.kind="dragon";
        newPet.name="Scooby";

        newPet.action();

    }
}

class Constants{
    static double PI=22.0/7.0;
    static double c= 3E+8;
    public static void main(String[] args) {
        double mass;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mass");
        mass=sc.nextDouble();
        double energy = mass*c*c;
        System.out.println("The energy producable is "+energy);
    }
}
