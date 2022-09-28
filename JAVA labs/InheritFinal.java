public class InheritFinal {
    public static void main(String[] args) {
        
        Animals animal1 = new Animals("kage",2);
        Dogs dog1 = new Dogs("charlie",5);

        animal1.run();
        animal1.shout();

        dog1.run();
        dog1.shout();
    }
}

class Animals{
    
    String name;
    int age;

    Animals (String name, int age){
        this.name = name;
        this.age = age;
    }

    void shout(){
        System.out.println("Makes angry animal noises");
    }

    final void run(){
        System.out.println("runs 100m away from you");
    }

}

class Dogs extends Animals{

    Dogs(String name,int age){
        super(name, age);
    }
    @Override
    void shout(){
        System.out.println("Barks angrily");
    }

    //@Override
    //void run(){
        //not possible to override final methods
    //}
}