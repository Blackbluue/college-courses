 /**
  * File: MillerRaymone_Project.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Final Project
  * Creation Date: (1APR21)
  * Description: Create a program that stores and displays
                 employee data, entered by the user
  */

package com.miller.millerraymone_week7disc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
                    if(size == 0)
                        System.out.println("\tNo employees added to list");
                    else
                        displayEmployeeData(employees, size);
                    break;
                case GET:
                    Employee empCopy = getEmployeeData(sc, employees, size);
                    if(empCopy == null)
                        System.out.println("\tEmployee could not be found");
                    else
                        displayEmployeeData(new Employee[]{empCopy}, 1);
                    break;
                case RANGE:
                    Employee[] empCopys = getEmployeeRange(sc, employees, size);
                    if(empCopys.length == 0)
                        System.out.println("\tSalary not found");
                    else
                        displayEmployeeData(empCopys, empCopys.length);
                    break;
                case EXIT:
                    System.out.println("Thank you for using the HR system.");
                    break;
            }
            System.out.println();
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
            "6. Exit\n");
        return (int) getUserNumber(sc, "Enter your menu choice: ",
            input -> input < LOAD || input > EXIT);
    }

    public static int loadEmployeeData(Scanner sc, Employee[] employees, int size) {
        int toAdd = (int) getUserNumber(sc,
            "\tHow many employees do you want to load? ", input -> input <= 0);
        if(toAdd > employees.length - size) {
            toAdd = employees.length - size;
            System.out.printf(
                "\tEmployee list limit will be reached. %d employees will be added\n",
                toAdd);
        }
        for(int i = 0; i < toAdd; i++) {
            System.out.printf("Employee %d of %d\n", i + 1, toAdd);
            size = addEmployeeData(sc, employees, size);
        }
        return size;
    }

    public static int addEmployeeData(Scanner sc, Employee[] employees, int size) {
        if(size >= employees.length) {
            System.out.println(
                "Employee list limit has been reached. Cannot add new employee.");
            return size;
        }
        System.out.print("\n\tEnter the name of the employee: ");
        String name = sc.nextLine();

        int id;
        boolean invalidID;
        do {
            invalidID = false;
            id = (int) getUserNumber(sc, "\tEnter the employee id number: ",
                input -> input < 10000 || input > 99999);
            for(int i = 0; i < size; i++) {
                if(id == employees[i].getID()) {
                    System.out.println("\tThat ID is used. Enter a unique ID.");
                    invalidID = true;
                    break;
                };
            }
        } while(invalidID);

        double salary = getUserNumber(sc, "\tEnter the employee's yearly salary: ",
            input -> input <= 0);

        employees[size] = new Employee(name, id, salary);
        return ++size;
    }

    public static void displayEmployeeData(Employee[] employees, int size) {
        Arrays.parallelSort(employees, 0, size);
        System.out.println();
        for(int i = 0; i < size; i++)
            System.out.printf(
                "\tEmployee Name: %s; ID: %d; Yearly Salary: $%,.2f\n",
                employees[i].getName(), employees[i].getID(),
                employees[i].getSalary());
    }

    public static Employee getEmployeeData(Scanner sc, Employee[] employees, int size) {
        int id = (int) getUserNumber(sc, "Enter the employee id number: ",
            input -> input < 10000 || input > 99999);
        for(int i = 0; i < size; i++)
            if(employees[i].getID() == id)
                return employees[i];
        return null;
    }

    public static Employee[] getEmployeeRange(Scanner sc, Employee[] employees, int size) {
        List<Employee> empReturns = new ArrayList<>();
        int minSal = (int) getUserNumber(sc, "Enter the minimum employee salary: ",
            input -> input < 0);
        int maxSal = (int) getUserNumber(sc, "Enter the maximum employee salary: ",
            input -> input <= 0 || input < minSal);

        for(int i = 0; i < size; i++) {
            if(employees[i].getSalary() >= minSal && employees[i].getSalary() <= maxSal)
                empReturns.add(employees[i]);
        }
        return empReturns.toArray(new Employee[0]);
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
            } catch(NumberFormatException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again");
            }
        } while(badInput);
        return input;
    }

    static class Employee implements Comparable<Employee> {
        // name of employee
        private String name;
        // ID of employee
        /* as this is an identifying value, the implication is that
           this value should be constant*/
        private final int id;
        // yearly salary of the employee
        private double salary;

        /**
         * 
         */
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

        public int compareTo(Employee other) {
            return this.name.compareTo(other.name);
        }
    }
}