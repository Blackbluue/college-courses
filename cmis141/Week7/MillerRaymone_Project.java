 /**
  * File: MillerRaymone_Project.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Final Project
  * Creation Date: (1APR21)
  * Description: Create a program that stores and displays
                 employee data, entered by the user
  */

package com.miller.millerraymone_week7disc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.function.Predicate;

public class MillerRaymone_Week7Disc {
    public static final int LOAD = 1;
    public static final int ADD = 2;
    public static final int DISPLAY = 3;
    public static final int GET = 4;
    public static final int RANGE = 5;
    public static final int EXIT = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100];
        int size = 0;
        int choice;

        do {
            choice = displayMenu(sc);
            switch(choice) {
                case LOAD:
                    size = loadEmployeeData(sc, employees, size);
                    break;
                case ADD:
                    size = addEmployeeData(sc, employees, size);
                    break;
                case DISPLAY:
                    displayEmployeeData(Arrays.copyOfRange(employees, 0, size));
                    break;
                case GET:
                    Employee empCopy = getEmployeeData(sc, employees, size);
                    displayEmployeeData({empCopy});
                    break;
                case RANGE:
                    Employee[] empCopys = getEmployeeRange(sc, employees, size);
                    displayEmployeeData(empCopy);
                    break;
                case EXIT:
                    System.out.println("Thank you for using the HR system.");
                    break;
            }
        } while(choice != EXIT);
    }

    public static int displayMenu(Scanner sc) {
        int choice;
        System.out.println(
            "1. Load Employees' data\n" + 
            "2. Add Employee Data\n" + 
            "3. Display All Employee Data\n" + 
            "4. Retrieve Specific Employee’s Data\n" + 
            "5. Retrieve Employees with Salaries Based on Range\n" + 
            "6. Exit");
        return getUserNumber(sc, "Enter your menu choice: ",
            input -> input < LOAD || input > EXIT);
    }

    public static int loadEmployeeData(Scanner sc, Employee[] employees, int size) {
        int toAdd = getUserNumber(sc, "How many employees do you want to load? ",
            input -> input <= 0);
        for(int i = 0; i < toAdd; i++)
            size = addEmployeeData(sc, employees, size);
        return size;
    }

    public static int addEmployeeData(Scanner sc, Employee[] employees, int size) {
        System.our.print("Enter the name of the employee: ");
        String name = sc.nextLine();

        int id = getUserNumber(sc, "Enter the employee id number: ",
            input -> input < 10000 || input > 99999);

        double salary = getUserNumber(sc, "Enter the employee's yearly salary: ",
            input -> input <= 0);

        employees[size] = new Employee(name, id, salary);
        return ++size;
    }

    public static void displayEmployeeData(Employee[] employees) {
        for(Employee emp: employees)
            System.out.printf(
                "\tEmployee Name: %s; ID: %d; Yearly Salary: %.2f\n",
                emp.getName(), emp.getID(), emp.getSalary());
    }

    public static Employee getEmployeeData(Scanner sc, Employee[] employees, int size) {
        Employee empReturn;
        int id = getUserNumber(sc, "Enter the employee id number: ",
            input -> input < 10000 || input > 99999);
        for(int i = 0; i < size; i++) {
            empReturn = employees[i];
            if(empReturn.getID() == id)
                return empReturn;
        } while(empReturn != null);
        return null;
    }

    public static Employee[] getEmployeeRange(Scanner sc, Employee[] employees, int size) {
        List<Employee> empReturns = new ArrayList<>();
        int minSal = getUserNumber(sc, "Enter the minimum employee salary: ",
            input -> input <= 0);
        int maxSal = getUserNumber(sc, "Enter the maximum employee salary: ",
            input -> input <= 0 || input < minSal);

        for(int i = 0; i < size; i++) {
            Employee emp = employees[i];
            if(emp.getSalary() >= minSal && emp.getSalary <= maxSal)
                empReturns.add(emp);
        }
        return empReturns;
    }

    public static double getUserNumber(
        Scanner sc, String prompt, Predicate<Double> invalid) {
        double input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = Double.valueOf(sc.nextLine());
                if(invalid.test(input))  // test input
                    System.out.println("\tNumber is invalid. try again");
                else
                    badInput = false;
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again");
                sc.nextLine();  // clear scanner of bad input
            }
        } while(badInput);
        return input;
    }

    class Employee {
        private String name;
        private final int id;
        private double salary;

        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        String getName() {
            return this.name;
        }

        int getID() {
            return this.id;
        }

        double getSalary() {
            return this.salary;
        }
    }
}