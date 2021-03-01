def main():
    # The hourly pay rate for the employee
    hourly_rate = 22.35

    # The commission rate
    commission_rate = .05

    # Get the number of hours worked by the employee this week.
    # May be fractional
    hours_worked = float(input("How many hours have you worked this week? "))

    # Get the total amount of sales for this week,
    # used to determine commision
    sales = float(input("What were your weekly sales? "))

    # compute the employee's total pay
    base_pay = hourly_rate * hours_worked
    commission = commission_rate * sales

    # Report pay amounts to employee
    print(f"\nYour base pay is ${base_pay:.2f}.")
    print(f"Your commission is ${commission:.2f}.")
    print(f"Your total pay is ${(base_pay + commission):.2f}.")

if __name__ == "__main__":
    main()
