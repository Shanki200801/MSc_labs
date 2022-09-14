public class ConstructorOverloading {
    public static void main(String[] args){
        Student stu1= new Student("shashank",21,"SJU");
        Student stu2= new Student("siddharth",21);
        stu1.display();
        stu2.display();
        
        
    }
}
class Student{
    String name,college;
    int age;
    Student(String name, int age, String college){
        this.name=name;
        this.age=age;
        this.college=college;
    }
    Student(String name, int age){
        this.name=name;
        this.age=age;
        System.out.println(this.name+" has not provided college information");
        this.college="unknown";
    }
    void display(){
        System.out.println("Name : "+ this.name);
        System.out.println("age : "+ this.age);
        System.out.println("College : "+ this.college);
        boolean discount = (college.equals("SJU")? true:false);
        if(discount)System.out.println("Student eligible for discount"); 
        System.out.println();
    }
}
