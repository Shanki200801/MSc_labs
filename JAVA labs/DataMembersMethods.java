class Animal{
    int legsNo = 4;
    String name;
    String owner;
    int age;
    Animal(String name, String owner, int age){
        this.name=name;
        this.owner=owner;
        this.age=age;
    }
}

class Dog extends Animal{
    Dog(String name, String owner, int age){
        super(name,owner,age);
    }
    void displayDog(){
        System.out.println("Name of the dog is "+name);
        System.out.println("Age of the dog is "+age);
        System.out.println("Name of the owner is "+owner);
    }
}

public class DataMembersMethods {
    public static void main(String[] args) { 
        Animal my_animal1 = new Animal("Charlie", "Vayu", 5);
        Animal my_animal2 = new Animal("brown", "white", 8);
        Dog my_dog = new Dog("joy", "barrow", 9);
        if(my_animal1.age<my_animal2.age){
            System.out.println(my_animal2.name+ " is older");
        }
        else{
            System.out.println(my_animal1.name+ " is older");
        }
    } 
}