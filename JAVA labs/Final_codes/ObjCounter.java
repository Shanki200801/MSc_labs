/*-----------------------------------------------------------
Program to count the number of instances a class contains
@Author - Shashank
-------------------------------------------------------------*/
package Final_codes;

class CountEmployeeClass {
    static private int obj_count = 0;

    public static int getCount() {
        return obj_count;
    }

    public static void plusCounter() {
        obj_count++;
    }
}

class Employee {
    String name;
    double salary, age;

    Employee(String name, int salary, int age) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // non- static block increasing the counter when an object is created
    {
        CountEmployeeClass.plusCounter();
    }

}

public class ObjCounter {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Employee e1 = new Employee("shashank", 10000, 25);
        Employee e2 = new Employee("shank", 100060, 21);
        Employee e3 = new Employee("shanki", 1000, 23);
        System.out.println("The number of objects in Employee class is " + CountEmployeeClass.getCount());
    }

}
