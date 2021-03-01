import math
# alt + 0176 for degree symbol °
# alt + 227 for pi symbol π
# alt + 231 for tau symbol τ
def main():
    print("π (pi) has its uses, but τ (tau) can be just as good! It is "
        "equivanlent to 2π, making many formulas involving π a lot simpler.\n\n"
        "Lets define a cirle using τ instaed of π.")
    # User input and validation
    radius = float(input("Input the radius of the circle: "))
    while radius <= 0:
        radius = eval(input("Radius must be a positive number: "))
    deg = int(input("Input the angle of the cirlce to measure (0°-360°): "))
    while deg not in range(0, 361):
        deg = int(input("Please input an angle between 0° and 360°: "))
    # Convert degrees to radians, using tau instead of pi
    rads = deg * (math.tau / 360)

    # Compute values based on user input, then print results
    print(f"\n{'Radius: ':<16}{radius}\n"
        f"{'Given Angle: ':<16}{deg}°\n"
        f"{'Coordinates: ':<16}"
        f"({get_x_coordinate(rads, radius)}, {get_y_coordinate(rads, radius)})\n"
        f"{'Sine: ':<16}{math.sin(rads)}\n"
        f"{'Cosine: ':<16}{math.cos(rads)}\n"
        f"{'Tanget: ':<16}{math.tan(rads)}\n"
        f"{'Area: ':<16}{get_area(radius)}\n"
        f"{'Circumfrence: ':<16}{get_circumfrence(radius)}\n")
    print(f"Remember, τ = 2π is {math.tau == 2 * math.pi}."
        "Let's celebrate Tau day!")

def get_y_coordinate(rads, radius):
    """Calculate y-coordiante of point on circle, given radians and radius."""
    # Get absolute value to represent real life measurements
    return math.sin(rads) * radius


def get_x_coordinate(rads, radius):
    """Calculate x-coordiante of point on circle, given radians and radius."""
    # Get absolute value to represent real life measurements
    return math.cos(rads) * radius


def get_area(radius):
    """Calculate area of a circle, given its radius."""
    return (math.tau * math.pow(radius, 2)) / 2


def get_circumfrence(radius):
    """Calculate circumfrence of a circle, given its radius."""
    return math.tau * radius


if __name__ == "__main__":
    main()
