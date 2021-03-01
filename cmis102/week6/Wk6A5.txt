def main():
    # Explain program
    print("This program will check your password strength for security.")
    # Prompt user for password to be checked
    password = input("Please input your password: ")
    # Display response to password checker
    print(pass_checker(password))


def pass_checker(password):
    # Criteria for a valid password
    minimun_length, maximum_length = 8, 16  # min, max password length
    invalid_substring = "umgc"  # subtring must not appear in password
    # Character must appear in password, but not in first or last position
    req_symbol = "#"
    # Password validation checks
    if len(password) < minimun_length:
        response = ("Your password is too short. It must be a minimum of "
            f"{minimun_length} characters.")
    elif len(password) > maximum_length:
        response = ("Your password is too long. It must be a maximum of "
            f"{maximum_length} characters.")
    elif invalid_substring in password.lower():
        response = ("Your password must not include the substring "
            f"'{invalid_substring}' in any combination of upper or lower "
            "case letters.")
    elif (req_symbol not in password or
        password[0] == req_symbol or password[-1] == req_symbol):
        response =( f"Your password must include a '{req_symbol}', but it "
            "cannot be the first or last character.")
    else:
        response = "That is a valid password."
    # Return response
    return response

if __name__ == "__main__":
    main()
