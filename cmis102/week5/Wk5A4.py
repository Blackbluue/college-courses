def main():
    # List of students
    students = {
        "Clark": None,
        "Bruce": None,
        "Diana": None,
        "Barry": None,
        "Oliver": None,
    }

    for name in students.keys():
        # Prompt for each student's quiz grade
        students[name] = int(input(f"Input {name}'s test score: "))

    # Calculate the average of all students' quiz scores
    avg = sum(students.values()) / len(students)
    # Get the highest quiz grade. student[1] == student quiz score
    highest = max(students.items(), key=lambda student: student[1])
    print(f"The average of all quiz grades is {avg}.\n"
        f"The student with the highest quiz score is {highest[0]} "
        f"with a grade of {highest[1]}.")

if __name__ == "__main__":
    main()
