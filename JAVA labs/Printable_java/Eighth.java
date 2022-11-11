package Printable_java;

import java.util.Scanner;

import Printable_java.Work.Employee;

public class Eighth {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees");
        int n = sc.nextInt();
        sc.nextLine();
        Employee[] emp_list = new Employee[n];

        System.out.println("Enter the name, salary and age of the list of employees");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of employee number " + (i + 1));
            String name = sc.nextLine();
            int salary = sc.nextInt();
            int age = sc.nextInt();
            sc.nextLine();
            emp_list[i] = new Employee(name, salary, age);
        }

        // Adding bonus to salary
        emp_list = Employee.addBonusToEmpList(emp_list);

        // displaying
        Employee.display(emp_list);

    }
}
