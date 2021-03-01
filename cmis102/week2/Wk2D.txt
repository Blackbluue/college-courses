def main():
    # Date ranges that define zodiac signs
    zodiac_date_ranges = {
        "january": {**dict.fromkeys(range(1, 20), "Capricorn"), **dict.fromkeys(range(20, 32), "Aquarius")},
        "february": {**dict.fromkeys(range(1, 19), "Aquarius"), **dict.fromkeys(range(19, 29), "Pisces")},
        "march": {**dict.fromkeys(range(1, 21), "Pisces"), **dict.fromkeys(range(21, 32), "Aries")},
        "april": {**dict.fromkeys(range(1, 20), "Aries"), **dict.fromkeys(range(20, 31), "Taurus")},
        "may": {**dict.fromkeys(range(1, 21), "Taurus"), **dict.fromkeys(range(21, 32), "Gemini")},
        "june": {**dict.fromkeys(range(1, 21), "Gemini"), **dict.fromkeys(range(21, 31), "Cancer")},
        "july": {**dict.fromkeys(range(1, 23), "Cancer"), **dict.fromkeys(range(23, 32), "Leo")},
        "august": {**dict.fromkeys(range(1, 23), "Leo"), **dict.fromkeys(range(23, 32), "Virgo")},
        "september": {**dict.fromkeys(range(1, 23), "Virgo"), **dict.fromkeys(range(23, 31), "Libra")},
        "october": {**dict.fromkeys(range(1, 23), "Libra"), **dict.fromkeys(range(23, 32), "Scorpio")},
        "november": {**dict.fromkeys(range(1, 22), "Scorpio"), **dict.fromkeys(range(22, 31), "Sagittarius")},
        "december": {**dict.fromkeys(range(1, 22), "Sagittarius"), **dict.fromkeys(range(22, 32), "Capricorn")}
    }

    # Ask for input from user for their birth month
    month = input("What month were you born in? (ie. January) ")
    # Ask for input from user for their birth date
    date = int(input("What date where you born on? (ie. 15) "))

    # Validate input
    if month.lower() not in zodiac_date_ranges:
        print(f"{month} is not a valid month.")
    elif date not in zodiac_date_ranges[month.lower()]:
        print(f"{date} is not a valid date.")
    else:
        # Display results
        print(f"Your Zodiac sign is {zodiac_date_ranges[month.lower()][date]}.")


# Execute program
if __name__ == "__main__":
    main()
