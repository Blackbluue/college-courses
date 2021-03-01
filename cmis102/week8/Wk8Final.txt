def main():
    # names of idividuals
    names = ["Banner", "Stark", "Rogers", "Romanoff", "Odinson", "Barton"]
    # list for bmi
    bmi_list = []
    # dictionary for counter of obesity health ratings
    obesity_counter = {rating: 0 for rating in ["Underweight", "Normal", "Overweight"]}

    # get user input for each individual
    for name in names:
        height = int(input(f"What is the height for {name} in inches? "))
        weight = int(input(f"What is the weight for {name} in pounds? "))
        bmi_list.append(get_bmi(height, weight))

    # tally up obesity ratings
    for bmi in bmi_list:
        obesity_counter[health_rater(bmi)] += 1

    # output results of obesity counters
    print("Obesity counter for supplied individuals:")
    for rating, count in obesity_counter.items():
        print(f"{rating}: {count}")


def get_bmi(height, weight):
    """Calculate the bmi of an individual."""
    # formula to calculate bmi
    return weight * 703 / height ** 2


def health_rater(bmi):
    """Determine the health rating based on bmi."""
    if bmi < 18.5:
        return "Underweight"
    elif bmi < 25:
        return "Normal"
    else:
        return "Overweight"


if __name__ == '__main__':
    main()
