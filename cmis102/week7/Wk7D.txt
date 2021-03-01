def main():
    numbers = []  # list for user input
    print("Program to list all prime factors of given numbers.")
    user_in = input("Input a number. Type 'q' to quit: ")

    while user_in.lower() != "q":
        if is_number(user_in):  # add to list if its a number
            numbers.append(int(user_in))
        elif user_in.lower() == "q":  # quit loop
            continue
        else:  # bad input
            print("Input not recognized")
        user_in = input("Input a number. Type 'q' to quit: ")

    # initial output
    print(f"Given numbers are as follows:\n {numbers}")
    for index, number in enumerate(numbers):
        # factor number and convert to string
        numbers[index] = (number, " x ".join(str(factored) for factored in factorize(number)))

    # follow up output
    print("Given numbers after factoring are as follows:")
    for number, factored in numbers:
        if f"1 x {number}" in factored:  # check for prime number
            print(f"{number} = {factored} Prime Number")  # special output
        else:
            print(f"{number} = {factored}")


def factorize(number):
    """Factor a number into a list of its prime factors."""
    if number < 0:  # number is negative
        prime_factors = [-1]  # add -1 to factors list
        number = -number  # flip sign
    else:  # number is positive
        prime_factors = []
    factor = 2
    while factor <= number // 2:
        if number % factor == 0:  # check if is a factor
            prime_factors.append(factor)
            number = number // factor  # floor divide to remove possible decimal
            factor = 2  # reset factor
        else:
            factor += 1
    else:
        if not prime_factors:  # check if prime_factors is empty
            # number is prime
            prime_factors.extend([1, number])
        else:  # number is not prime, or is a negative prime
            prime_factors.append(number)
    return prime_factors


def is_number(num):
    """Check if a given object is a number."""
    try:
        int(num)  # try to convert to an int
        # this will also work with negative numbers
    except ValueError:
        return False  # if fails, return False
    return True  # if succeeds, return True


if __name__ == "__main__":
    main()
