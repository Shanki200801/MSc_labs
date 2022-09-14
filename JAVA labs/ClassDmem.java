import DataStructures.*;
public class ClassDmem {
    private IntStack stack1 = new IntStack();
    public IntStack stack2 = new IntStack();
    protected IntStack stack3 = new IntStack();    
}
class externalClass{
        public static void main(String[] args) {
        ClassDmem object1 = new ClassDmem();
        object1.stack2.push(50);
        object1.stack2.push(60);        
        //test2.stack1.display() not visible because it is private
    }
}

class childClass extends ClassDmem{
    public static void main(String[] args) {
        childClass obj3 = new childClass();
        obj3.stack2.display();
        obj3.stack3.display();//public and protected are inherited
        //obj3.stack1.display(); invisible  because it is private
    }
}
