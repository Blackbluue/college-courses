 /**
  * File: MillerRaymone_Project.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Final Project
  * Creation Date: (1APR21)
  * Description: Create a program that stores and displays
                 employee data, entered by the user
  */

package com.miller.millerraymone_week7disc;

import java.util.*;
import java.util.function.Predicate;

public class MillerRaymone_Week7Disc {
    // constants for menu choices
    public static final int LOAD = 1;
    public static final int ADD = 2;
    public static final int DISPLAY = 3;
    public static final int GET = 4;
    public static final int RANGE = 5;
    public static final int EXIT = 6;
    // open scanner
    public static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        // list to hold employee data
        EmployeeList employees = new EmployeeList(100);
        //Employee[] employees = new Employee[100];
        // user input
        int choice;

        // do-while loop to control program flow
        do {
            choice = displayMenu(SC);
            switch(choice) {
                case LOAD:  // add multiple employees
                    int added = loadEmployeeData(employees);
                    System.out.printf("%d employees have been added to the list",
                        added);
                    break;
                case ADD:  // add one employee
                    if(addEmployeeData(employees))
                        System.out.println("\tEmployee successfully added");
                    else
                        System.out.println("\tList full, employee not added.");
                    break;
                case DISPLAY:  // display all current employee data
                    if(employees.isEmpty()) {  // special message for empty employee list
                        System.out.println("\tNo employees added to list");
                    } else {
                        System.out.printf("\n\tDisplaying %d employees' data\n",
                            employees.size());
                        displayEmployeeData(employees.toArray(new Employee[0]));
                    }
                    break;
                case GET:  // get data for a specific employee
                    Employee empCopy = getEmployeeData(employees);
                    if(empCopy == null)  // special message if employee not found
                        System.out.println("\tEmployee could not be found");
                    else  // method needs an array so make singleton
                        displayEmployeeData(empCopy);
                    break;
                case RANGE:  // get data based on salary range
                    Employee[] empCopys = getEmployeeRange(employees);
                    if(empCopys.length == 0)  // special message when salary not found
                        System.out.println("\tSalary not found");
                    else
                        displayEmployeeData(empCopys);
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
     * @return An int representing the user's choice.
     */
    public static int displayMenu() {
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
        return (int) getUserNumber(SC, "Enter your menu choice: ",
            input -> input < LOAD || input > EXIT);
    }

    /**
     * Add multiple employees to the employee list. Will reject addition
     * if the list is full.
     *
     * @param employees The list of employees.
     * @return The amount of employees added to the list.
     */
    public static int loadEmployeeData(EmployeeList employees, int size) {
        // the amount of employees to add
        int toAdd = (int) getUserNumber(SC,
            "\tHow many employees do you want to load? ", input -> input <= 0);

        // loop to add employees 
        for(int i = 0; i < toAdd; i++) {
            System.out.printf("Employee %d of %d\n", i + 1, toAdd);
            // update toAdd if list limit has been reached
            if(!addEmployeeData(employees))
                toAdd = i;
        }
        return toAdd;
    }

    /**
     * Add a single employee to the employee list. Will reject the addition if
     * the list is full.
     *
     * @param employees The list of employees.
     * @return true if the employee was added to the list.
     */
    public static boolean addEmployeeData(EmployeeList employees) {
        // check if the list has space for a new employee
        if(employees.isFull()) {
            System.out.println(
                "\tEmployee list limit has been reached. Cannot add new employee.");
            return false;
        }
        // get employee name
        System.out.print("\n\tEnter the name of the employee: ");
        String name = SC.nextLine();

        // get employee id
        int id;
        boolean invalidID;
        do {
            invalidID = false;
            // get user input, id must be 5 digits only
            id = (int) getUserNumber(SC, "\tEnter the employee id number: ",
                input -> input < 10000 || input > 99999);
            // check uniqueness of id
            if(!employees.validID(id)) {
                System.out.println("\tThat ID is used. Enter a unique ID.");
                invalidID = true;
            }
        } while(invalidID);  // if no duplicates, exit do-while loop

        // get employee salary. salary must be greater than 0
        double salary = getUserNumber(SC, "\tEnter the employee's yearly salary: ",
            input -> input <= 0);

        // once all data is collected, make Employee object and put in list
        employees.add(new Employee(name, id, salary));
        return true;
    }

    /**
     * Displays all the employee data currently in the array.
     *
     * @param employees The list of employees.
     */
    public static void displayEmployeeData(Employee... employees) {
        // sort array based on employee name
        Arrays.parallelSort(employees);

        // print each employee data, one employee per line
        for(Employee emp: employees)
            System.out.printf(
                "\tEmployee Name: %s; ID: %d; Yearly Salary: $%,.2f\n",
                emp.getName(), emp.getID(), emp.getSalary());
    }

    /**
     * Get the data for a specific employee, based on ID.
     *
     * @param employees The list of employees.
     * @return the requested employee, or null if not found.
     */
    public static Employee getEmployeeData(EmployeeList employees) {
        // get user input, for the specified id
        int id = (int) getUserNumber(SC, "\tEnter the employee id number: ",
            input -> input < 10000 || input > 99999);
        // loop over array until we find the specified id
        return employees.getFromID(id);
    }

    /**
     * Get the data for a range of employees, based on salary.
     *
     * @param employees The list of employees.
     * @return the requested range of employees, or empty array if not found.
     */
    public static Employee[] getEmployeeRange(EmployeeList employees) {
        // container for found employees
        List<Employee> empReturns = new ArrayList<>();
        // get input for min/max salary range
        int minSal = (int) getUserNumber(SC, "\tEnter the minimum employee salary: ",
            input -> input < 0);
        int maxSal = (int) getUserNumber(SC, "\tEnter the maximum employee salary: ",
            input -> input <= 0 || input < minSal);

        // loop over aray to find employees who fit in salary range
        for(Employee emp: employees) {
            if(emp.getSalary() >= minSal && emp.getSalary() <= maxSal)
                empReturns.add(emp);
        }
        // convert List into array and return. array will be size 0 if none found
        return empReturns.toArray(new Employee[0]);
    }

    /**
     * Collect user numerical input. Accepts a prompt and a predicate to determine
     * valid values for input.
     *
     * @param prompt The prompt to print to the screen.
     * @param invalid A Predicate used to determine invalid input.
     * @return a number from user input.
     */
    public static double getUserNumber(String prompt, Predicate<Double> invalid) {
        double input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = Double.valueOf(SC.nextLine());
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
    public static class Employee implements Comparable<Employee> {
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
         *
         * @return The name of the employee
         */
        String getName() {
            return this.name;
        }

        /**
         * Returns the ID of the employee.
         *
         * @return The Id of the employee
         */
        int getID() {
            return this.id;
        }

        /**
         * Returns the salary ofthe employee.
         *
         * @return The yearly salary of the employee
         */
        double getSalary() {
            return this.salary;
        }

        /**
         * Compares this Employee to the other for ordering.
         *
         * @param other The other Employee to compare to.
         */
         @override
        public int compareTo(Employee other) {
            return this.name.compareTo(other.name);
        }
    }

    public static class EmployeeList extends AbstractList<Employee> {
        private final Employee[] employees;
        private int size;

        /**
         * Sole constructor. Creates an empty Employee list with the
         * supplied initial capacity. The capacity of the list cannot be
         * changed once the list is created.
         *
         * @param initialCapacity The initial capacity for the list.
         */
        public EmployeeList(int initialCapacity) {
            this.employees = new Employee[initialCapacity];
            this.size = 0;
        }

        /**
         * Returns the number of elements in this list.
         *
         * @return The number of elements in this list
         */
        @override
        public int size() {
            return this.size;
        }

        /**
         * Returns the element at the specified position in this list.
         *
         * @param index index of the element to return.
         * @return the element at the specified position in this list.
         */
        @override
        public Employee get(int index) {
            return this.employees[index];
        }

        /**
         * Replaces the element at the specified position in this
         * list with the specified element.
         *
         * @param index index of the element to replace
         * @return the element previously at the specified position.
         */
        @override
        public Employee set(int index, Employee element) {
            Employee previous = this.employees[index];
            this.employees[index] = element;
            return previous;
        }

        /**
         * Inserts the specified element at the specified position in this list.
         * Shifts the element currently at that position (if any) and any
         * subsequent elements to the right (adds one to their indices).
         *
         * @param index index at which the specified element is to be inserted.
         * @param element element to be inserted.
         * @throws IllegalStateException If the list is alreayd full.
         */
        @override
        public void add​(int index, Employee element) {
            // check if list is full, throw exception if it is
            if(this.isFull())
                throw new IllegalStateException("Employee list limit has been reached. Cannot add new employee.");

            // shift any elements after the requested index to the right
            for(int i = this.size; i > index; i++)
                this.employees[i] = this.employees[i - 1];
            // insert element
            this.employees[index] = element
        }

        /**
         * Return the Employee with the specified ID number.
         *
         * @param id ID of the employee.
         * @return the employee with the specified ID.
         */
        public Employee getFromID(int id) {
            for(int i = 0; i < this.size; i++)
                if(this.employees[i].getID() == id)
                    return this.employees[i];  // return Employee object when found
            // if id not found, return null
            return null;
        }

        /**
         * Returns true if this list is full, based on the initial capacity.
         *
         * @return true if this list is full.
         */
        public boolean isFull() {
            return this.size == this.employees.length;
        }

        /**
         * Returns true if the specified ID has not been used.
         *
         * @return true if the specified ID has not been used.
         */
        public boolean validID(int id) {
            for(int i = 0; i < this.size; i++)
                if(id == this.employees[i].getID())
                    return false;
            return true;
        }
    }
}