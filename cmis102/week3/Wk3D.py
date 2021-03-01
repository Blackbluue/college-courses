from collections import namedtuple

def main():
    # define a pirate by their name and bounty
    Pirate = namedtuple("Pirate", "name, bounty")
    # list all straw hat pirates and collect them in a dictionary
    mugiwara_no_ichimi = {
        "luffy": Pirate("\"Straw Hat\" Monkey D. Luffy", 1_500_000_000),
        "zoro": Pirate("\"Pirate Hunter\" Roronoa Zoro", 320_000_000),
        "usopp": Pirate("\"God\" Usopp", 200_000_000),
        "sanji": Pirate("\"Black Leg\" Vinsmoke Sanji", 330_000_000),
        "nami": Pirate("\"Cat Burglar\" Nami", 66_000_000),
        "chopper": Pirate("\"Cotton Candy Lover\" Tony Tony Chopper", 100),
        "robin": Pirate("\"Devil Child\" Nico Robin", 130_000_000),
        "franky": Pirate("\"Iron Man\" Franky", 94_000_000),
        "brook": Pirate("\"Soul King\" Brook", 83_000_000),
        "jinbei": Pirate("\"Knight of the Sea\" Jinbei", 438_000_000)
    }

    print("I can predict which of the Straw Hat pirates you are most like. "
            "But first I need you to answer a few questions. "
            "Answer them to the best of your ability.")

    # collect user input by asking them questions
    # report the name and bounty of the resulting pirate
    grand_line = validate_input(
        "Did you meet the crew on the Grand Line? Y/N ",[ "Y", "N"])
    if grand_line == "N":
        # Luffy, Zoro, Usopp, Sanji, Nami
        tools = validate_input("Do you use tools to fight? Y/N ", ["Y", "N"])
        if tools == "Y":
            # Zoro, Usopp, Nami
            fun = validate_input("What is your favorite pass time? "
                "drinking, stealing, or pranks ",
                ["drinking", "stealing", "pranks"])
            if fun == "drinking":
                # Zoro
                print(f"You are most like {mugiwara_no_ichimi['zoro'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['zoro'].bounty:,} beri.")
            elif fun == "stealing":
                # Nami
                print(f"You are most like {mugiwara_no_ichimi['nami'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['nami'].bounty:,} beri.")
            else:
                # Usopp
                print(f"You are most like {mugiwara_no_ichimi['usopp'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['usopp'].bounty:,} beri.")
        else:
            # Luffy, Sanji
            powers = validate_input("Do you have Devil Fruit Powers? Y/N ",
                ["Y", "N"])
            if powers == "Y":
                # Luffy
                print(f"You are most like {mugiwara_no_ichimi['luffy'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['luffy'].bounty:,} beri.")
            else:
                # Sanji
                print(f"You are most like {mugiwara_no_ichimi['sanji'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['sanji'].bounty:,} beri.")
    else:
        # Chopper, Robin, Franky, Brook, Jinbei
        powers = validate_input("Do you have Devil Fruit Powers? Y/N ",
            ["Y", "N"])
        if powers == "Y":
            # Chopper, Robin, Brook
            job = validate_input("Would you like to be a doctor, archeologist, "
                "or musician? ", ["doctor", "archeologist", "musician"])
            if job == "doctor":
                # Chopper
                print(f"You are most like {mugiwara_no_ichimi['chopper'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['chopper'].bounty:,} beri.")
            elif job == "archeologist":
                # Robin
                print(f"You are most like {mugiwara_no_ichimi['robin'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['robin'].bounty:,} beri.")
            else:
                # Brook
                print(f"You are most like {mugiwara_no_ichimi['brook'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['brook'].bounty:,} beri.")
        else:
            # Franky, Jinbei
            like = validate_input("Do you like fish or cyborgs? ",
                ["fish", "cyborgs"])
            if like == "fish":
                # Jinbei
                print(f"You are most like {mugiwara_no_ichimi['jinbei'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['jinbei'].bounty:,} beri.")
            else:
                # Franky
                print(f"You are most like {mugiwara_no_ichimi['franky'].name} "
                    f"with a bounty of {mugiwara_no_ichimi['franky'].bounty:,} beri.")


def validate_input(prompt, choices):
    """Validate user input, based on a predefined set of choices."""
    response = input(prompt)
    # continue to loop until a suitable option is chosen
    while response not in choices:
        response = input(f"Choose one of the following: '{choices}' ")
    return response


if __name__ == "__main__":
    main()
