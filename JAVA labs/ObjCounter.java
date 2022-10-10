import java.lang.reflect.Field;

class CountEmployeeClass{
    static private int obj_count=0;
    public static int getCount(){
        return obj_count;
    }
    public static void plusCounter(){
        obj_count++;
    }
}

class Employee{
    String name;
    double salary,age;
    Employee(String name,int salary,int age){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    {CountEmployeeClass.plusCounter();}

    static Employee addYearlyBonus(Employee obj){
        obj.age++;
        obj.salary=obj.salary+0.05*obj.salary;
        return obj;
    }
}

public class ObjCounter {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Employee e1 = new Employee("shashank", 10000, 25);
        Employee e2 = new Employee("shank", 100060, 21);
        Employee e3 = new Employee("shanki", 1000, 23);
        System.out.println("The number of objects in Employee class is "+CountEmployeeClass.getCount());        
        e1=Employee.addYearlyBonus(e1);

        for (Field field : e1.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(e1);
            System.out.printf("%s: %s%n", name, value);
        }    
    }
    
}
