from collections import namedtuple

def main():
    # Template to calculate movie ticket price
    # Surcharge for 3D movie is $2.50
    TicketPrice = namedtuple(
        "TicketPrice", "age base_price surcharge_3D")
    # child ticket; age <= 12; price = $5.00
    child_ticket = TicketPrice(12, 5.00, 2.50)
    # adult ticket; 12 < age < 55; price = $7.00
    adult_ticket = TicketPrice(None, 7.00, 2.50)
    # senior ticket; age >= 55; price = $4.50
    senior_ticket = TicketPrice(55, 4.50, 2.50)

    # Collect user input
    char = "*"  # fill character for pricing menu
    print("Hello, welcome to Star Theatres online ticketing booth!")
    print(f"{'':{char}^60}")
    print(f"{char}{'PRICES':^60}")
    print(f"{char} Regular ticket: ${adult_ticket.base_price:.2f}")
    print(f"{char} Children 12 and under: ${child_ticket.base_price:.2f}")
    print(f"{char} Senior citizens 55+: ${senior_ticket.base_price:.2f}")
    print(f"{char} Additional surcharge for 3D movies: ${adult_ticket.surcharge_3D:.2f}")
    print(f"{'':{char}^60}")
    age = int(input("What is your age? "))
    is_3D = input("Is the movie you are watching 3D? Y/N ")

    # Determine age range for ticket price, based on user input
    # Also factor in 3D movies
    if age <= child_ticket.age:
        ticket_price = calculate_price(child_ticket, is_3D)
    elif age >= senior_ticket.age:
        ticket_price = calculate_price(senior_ticket, is_3D)
    else:
        ticket_price = calculate_price(adult_ticket, is_3D)

    # Print the results to the screen
    if is_3D == "Y" or is_3D == "y":
        print(f"Your final charge will be ${ticket_price:.2f} and is in 3D. "
               "Happy viewing!")
    else:
        print(f"Your final charge will be ${ticket_price:.2f} and is not in 3D."
               " Happy viewing!")


# template_ticket will contain the base price of the ticket, based on the age
# of the movie goer, and also the surcharge price if it is needed.
def calculate_price(template_ticket, is_3D):
    """Calculate the price of the ticket and return it as an int."""
    # Only add surcharge if customer wants to see a 3D movie
    if is_3D == "Y" or is_3D == "y":
        return template_ticket.base_price + template_ticket.surcharge_3D
    else:
        return template_ticket.base_price


if __name__ == "__main__":
    main()
