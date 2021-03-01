# alt + 0176 for degree symbol °
def main():
    # Program introduction
    print("We will be gathering temperature data for the past 10 days.")

    c_temp_list = []
    # gather user input
    for day in range(10):
        temp = float(input(f"Input the temperature for day {day + 1} in celsius: "))
        c_temp_list.append(temp)

    # display temperatures in celsius
    print("The registered temperatures in celsius are as follows:\n",
        " ".join(str(c_temp) + "°" for c_temp in c_temp_list))

    # convert to fahrenheit, then display temperatures again
    # °F = (°C × 1.8) + 32
    f_temp_list = [(c_temp * 1.8) + 32 for c_temp in c_temp_list]
    print("The registered temperatures in fahrenheit  are as follows:\n",
        " ".join(str(f_temp) + "°" for f_temp in f_temp_list))

    # thresholds for cool, warm and hot days. all temps are in fahrenheit
    cool_threshold = 60  # x <= 60 for cool days
    warm_threshold = 80  # 60 < x <= 80 for warm days
    # x > 80 for hot days
    thresh_count = {"cool": 0, "warm": 0, "hot": 0}
    # tally temperatures for all days
    for f_temp in f_temp_list:
        if f_temp <= cool_threshold:
            thresh_count["cool"] += 1
        elif f_temp <= warm_threshold:
            thresh_count["warm"] += 1
        else:
            thresh_count["hot"] += 1
    # display tallys for temperature thresholds
    for threshold in thresh_count.items():
        print(f"{threshold[0]} days: {threshold[1]}")


if __name__ == "__main__":
    main()
