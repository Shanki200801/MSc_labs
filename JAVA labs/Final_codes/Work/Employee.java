package Final_codes.Work;

public class Employee {

    String name;
    int salary;
    int age;

    public Employee(String name, int salary, int age) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public static Employee[] addBonusToEmpList(Employee[] list) {
        for (Employee e : list) {
            e.salary += e.salary * .05;
        }
        return list;
    }

    public static void display(Employee[] list) {
        for (Employee e : list) {
            System.out.println(e.age + " years old " + e.name + " earns " + e.salary);
        }
    }

}
