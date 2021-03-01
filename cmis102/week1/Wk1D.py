from random import randint
def main():
    answer = randint(1, 10)
    attempts = 3
    print(f"I'm thinking of a number between 1 and 10. Try and guess it! You have {attempts} tries.")
    while attempts >= 1:
        guess = int(input(f"\nYou have {attempts} attempt(s) left: "))
        if guess == answer:
            print("That's correct!")
            attempts = 0
        else:
            print("Sorry, that's wrong.")
            if attempts == 1:
                print(f"The answer was {answer}.")
            elif guess < answer:
                print("Try higher next time.")
            else:
                print("Try lower next time.")
            attempts -= 1
    print("Lets play again sometime.")

if __name__ == "__main__":
    main()
