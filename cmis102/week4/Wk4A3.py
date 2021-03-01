def main():
    # Prices for carious carpet qualities, from lowest quality to highest
    quality_prices = [2.49, 5.99, 7.00]
    print("Welcome to Star Carpeting, where all of your carpeting needs are met!"
        " I'll ask you a few questions to get started.\n")
    # Collect user input
    width = int(input("What is the width of the room, in feet? "))
    height = int(input("What is the height of the room, in feet? "))
    print("\nWe have 3 qualities of carpeting for sale. Please make your "
        "selection by typing in the numerical menu item.\n"
        f"{'1. Low quality: ':<20}${quality_prices[0]:>4.2f}\n"
        f"{'2. Medium quality: ':<20}${quality_prices[1]:>4.2f}\n"
        f"{'3. High quality: ':<20}${quality_prices[2]:>4.2f}\n")
    # Input validation
    while True:
        quality = int(input("Input a number between 1 - 3: "))
        if quality in range(1, len(quality_prices) + 1):
            break

    # Call price calculation function
    total_price = carpet_price(height, width, quality_prices[quality - 1])
    # Print results
    print(f"\nThe total cost for your purchase is ${total_price:,.2f}")

def carpet_price(height, width, price_per_sqft):
    """Return the price per square foot of the carpet."""
    return height * width * price_per_sqft

if __name__ == "__main__":
    main()
