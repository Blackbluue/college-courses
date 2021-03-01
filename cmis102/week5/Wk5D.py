def main():
    print("Lets make a Welcome Mat pattern.")
    # Collect user input. Height must be odd for pattern to work.
    while True:
        height = int(input("Input an odd number greater than 1 for height: "))
        if height % 2 != 0 and height != 1:
            break
    # Width must be 3 times larger than height
    width = height * 3
    # Define how the pattern is built
    line = lambda size: "-" * size
    pattern = lambda size: ".|." * size
    # Welcome message at center of mat
    msg = "WELCOME"

    # Top and bottom halfs of mat are identical, only need to store one half
    mat_half = []
    # Build mat half, each row pattern is based on row number
    for row in range(height // 2):
        pat_str = pattern(row * 2 + 1)
        line_str = line((width - len(pat_str)) // 2)
        mat_half.append(line_str + pat_str + line_str)

    # Print out the full mat
    # top half
    row = 0  # index for mat_half
    while row < len(mat_half):
        print(mat_half[row])
        row += 1
    # center
    print(line(width // 2 - (len(msg) // 2)) + msg + line(width // 2 - (len(msg) // 2)))
    # bottom half
    row = len(mat_half) - 1  # index for mat_half, reversed
    while row >= 0:
        print(mat_half[row])
        row -= 1


if __name__ == "__main__":
    main()
