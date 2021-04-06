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
    // constants for menu choices
    public static final int LOAD = 1;
    public static final int ADD = 2;
    public static final int DISPLAY = 3;
    public static final int GET = 4;
    public static final int RANGE = 5;
    public static final int EXIT = 6;

    public static void main(String[] args) {
        // open scanner
        Scanner sc = new Scanner(System.in);
        // array to hold employee data
        Employee[] employees = new Employee[100];
        // the current amount of employee data in the array
        int size = 0;
        // user input
        int choice;

        // do-while loop to control program flow
        do {
            choice = displayMenu(sc);
            switch(choice) {
                case LOAD:  // add multiple employees
                    size = loadEmployeeData(sc, employees, size);
                    break;
                case ADD:  // add one employees
                    size = addEmployeeData(sc, employees, size);
                    break;
                case DISPLAY:  // display all current employee data
                    if(size == 0)  // special message for empty employee list
                        System.out.println("\tNo employees added to list");
                    else
                        displayEmployeeData(employees, size);
                    break;
                case GET:  // get data for a specific employee
                    Employee empCopy = getEmployeeData(sc, employees, size);
                    if(empCopy == null)  // special message if employee not found
                        System.out.println("\tEmployee could not be found");
                    else  // method needs an array so make singleton
                        displayEmployeeData(new Employee[]{empCopy}, 1);
                    break;
                case RANGE:  // get data based on salary range
                    Employee[] empCopys = getEmployeeRange(sc, employees, size);
                    if(empCopys.length == 0)  // special message when salary not found
                        System.out.println("\tSalary not found");
                    else
                        displayEmployeeData(empCopys, empCopys.length);
                    break;
                case EXIT:  // exit program
                    System.out.println("Thank you for using the HR system.");
                    break;
            }
            System.out.println();
        } while(choice != EXIT);
    }

    /**
     * Display menu and collect user iput.
     *
     * @param sc The scanner used in this program.
     * @return An int representing the user's choice.
     */
    public static int displayMenu(Scanner sc) {
        int choice;
        // print menu options
        System.out.println(
            "1. Load Employees' data\n" + 
            "2. Add Employee Data\n" + 
            "3. Display All Employee Data\n" + 
            "4. Retrieve Specific Employee’s Data\n" + 
            "5. Retrieve Employees with Salaries Based on Range\n" + 
            "6. Exit\n");
        // get use input, caste to int
        return (int) getUserNumber(sc, "Enter your menu choice: ",
            input -> input < LOAD || input > EXIT);
    }

    /**
     * Add multiple employees to the employee list.
     *
     * @param sc The scanner used in this program.
     * @param employees The array of employees.
     * @param size The current amount of employees in the array.
     * @return The current amount of employees in the array after addition
     */
    public static int loadEmployeeData(Scanner sc, Employee[] employees, int size) {
        // the amount of employees to add
        int toAdd = (int) getUserNumber(sc,
            "\tHow many employees do you want to load? ", input -> input <= 0);
        // check if the array has space to add the employees
        if(toAdd > employees.length - size) {
            // only add enough that the array has space for
            toAdd = employees.length - size;
            System.out.printf(
                "\tEmployee list limit will be reached. %d employees will be added\n",
                toAdd);
        }
        // loop to add employees 
        for(int i = 0; i < toAdd; i++) {
            System.out.printf("Employee %d of %d\n", i + 1, toAdd);
            // update size after each addition
            size = addEmployeeData(sc, employees, size);
        }
        return size;
    }

    /**
     * Add a single employee to the employee list.
     *
     * @param sc The scanner used in this program.
     * @param employees The array of employees.
     * @param size The current amount of employees in the array.
     * @return The current amount of employees in the array after addition
     */
    public static int addEmployeeData(Scanner sc, Employee[] employees, int size) {
        // chekc if the array has space for a new employee
        if(size >= employees.length) {
            System.out.println(
                "Employee list limit has been reached. Cannot add new employee.");
            // return the current size of the array without adding data
            return size;
        }
        // get employee name
        System.out.print("\n\tEnter the name of the employee: ");
        String name = sc.nextLine();

        // get employee id
        int id;
        boolean invalidID;
        do {
            invalidID = false;
            // get user input, id must be 5 digits only
            id = (int) getUserNumber(sc, "\tEnter the employee id number: ",
                input -> input < 10000 || input > 99999);
            // loop to check uniqueness of id
            for(int i = 0; i < size; i++) {
                if(id == employees[i].getID()) {
                    System.out.println("\tThat ID is used. Enter a unique ID.");
                    invalidID = true;
                    // break out of for-loop and redo do-while loop
                    break;
                };
            }
        } while(invalidID);  // if no duplicates, exit do-while loop

        // get employee salary. salary must be greater than 0
        double salary = getUserNumber(sc, "\tEnter the employee's yearly salary: ",
            input -> input <= 0);

        // once all data is collected, make Employee object and put in array
        employees[size] = new Employee(name, id, salary);
        // return the incremented size
        return ++size;
    }

    /**
     * Displays all the employee data currently in the array.
     *
     * @param employees The array of employees.
     * @param size The current amount of employees in the array.
     */
    public static void displayEmployeeData(Employee[] employees, int size) {
        // sort array based on employee name
        Arrays.parallelSort(employees, 0, size);
        System.out.println();
        // print each employee data, one employee per line
        for(int i = 0; i < size; i++)
            System.out.printf(
                "\tEmployee Name: %s; ID: %d; Yearly Salary: $%,.2f\n",
                employees[i].getName(), employees[i].getID(),
                employees[i].getSalary());
    }

    /**
     * Get the data for a specific employee, based on ID.
     *
     * @param sc The scanner used in this program.
     * @param employees The array of employees.
     * @param size The current amount of employees in the array.
     * @return the requested employee, or null if not found.
     */
    public static Employee getEmployeeData(Scanner sc, Employee[] employees, int size) {
        // get user input, for the specified id
        int id = (int) getUserNumber(sc, "\tEnter the employee id number: ",
            input -> input < 10000 || input > 99999);
        // loop over array until we find the specified id
        for(int i = 0; i < size; i++)
            if(employees[i].getID() == id)
                return employees[i];  // return Employee object when found
        // if id not found, return null
        return null;
    }

    /**
     * Get the data for a range of employees, based on salary.
     *
     * @param sc The scanner used in this program.
     * @param employees The array of employees.
     * @param size The current amount of employees in the array.
     * @return the requested list of employees, or empty array if not found.
     */
    public static Employee[] getEmployeeRange(Scanner sc, Employee[] employees, int size) {
        // container for found employees
        List<Employee> empReturns = new ArrayList<>();
        // get input for min/max salary range
        int minSal = (int) getUserNumber(sc, "\tEnter the minimum employee salary: ",
            input -> input < 0);
        int maxSal = (int) getUserNumber(sc, "\tEnter the maximum employee salary: ",
            input -> input <= 0 || input < minSal);

        // loop over aray to find employees who fit in salary range
        for(int i = 0; i < size; i++) {
            if(employees[i].getSalary() >= minSal && employees[i].getSalary() <= maxSal)
                empReturns.add(employees[i]);
        }
        // convert List into array and return. array will be size 0 if none found
        return empReturns.toArray(new Employee[0]);
    }

    /**
     * Collect user numerical input. Accepts a prompt and a predicate to determine
     * valid values for input.
     *
     * @param sc The scanner used in this program.
     * @param prompt The prompt to print to the screen.
     * @param invalid A Predicate used to determine invalid input.
     * @return a number from user input.
     */
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

    /**
     * Employee class to hold information on a single employee
     */
    static class Employee implements Comparable<Employee> {
        // name of employee
        private String name;
        // ID of employee
        private int id;
        // yearly salary of the employee
        private double salary;

        /**
         * Employee constructor.
         */
        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        /**
         * Returns the name of the employee.
         */
        String getName() {
            return this.name;
        }

        /**
         * Returns the ID of the employee.
         */
        int getID() {
            return this.id;
        }

        /**
         * Returns the salary ofthe employee.
         */
        double getSalary() {
            return this.salary;
        }

        /**
         * Compares this Employee to the other for ordering.
         *
         * @param other The other Employee to compare to.
         */
        public int compareTo(Employee other) {
            return this.name.compareTo(other.name);
        }
    }
}