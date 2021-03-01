# Sort a list of user supplied names in ascending order.
# Uses bubble sort algorithm for sorting.
def main():
    # Gather user input of list of names to sort
    # Use str.split() function to turn string into a list of strings
    names = input("Input a list of names, separated by spaces\n").split()
    size = len(names)
    for i in range(size - 1):
        # Flag value for optimization
        swapped = False
        for index  in range(size - 1):
            # Check if left is greater than right
            # left == names[index]
            # right == names[index + 1]
            if names[index] > names[index  + 1]:
                # If true, then swap elements
                names[index], names[index + 1] = names[index + 1], names[index]
                swapped = True
        # If no swaps this iteration of inner loop, break out of outer loop
        # Used to optimize sort, so no futher action is taken if list is sorted
        if not swapped:
            break

    # Display results of sorted list
    # Use str.join() to combine list back into a space separated string
    print(" ".join(names))


if __name__ == "__main__":
    main()
