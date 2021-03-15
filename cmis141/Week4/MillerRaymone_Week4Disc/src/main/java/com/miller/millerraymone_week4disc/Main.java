/** Daniels, Roderick
 *  CMIS141
 *  Week 4 - While Loop
 *  03/11/2021
 *  Prompt a user for how long of a password they would like and then
 *  generates a password of that length.
 */
import java.util.Random;  // introduce Random
import java.util.Scanner; // introducing Scanner

public class Main {
    /**
     * prompt user for length of password and generate that many random
     * characters
     */
    public static void main(String[] args) {
        // Create scanner object
        Scanner scanner = new Scanner(System.in);

        // initialize Random
        Random rnd = new Random();

        //initialize password variable
        String password = "";

        // prompt user for length of password
        System.out.println("How long of a password would you like?");
        int passwordLength = scanner.nextInt();

        do {
            if(passwordLength <= 0)
                break;
            // Character a is represented by index 97 so we start there and
            // randomly select a char between that and 26 index after (a-z)
            char c = (char) ('a' + rnd.nextInt(26));
            password += c;  // add the generated char to the current password
            System.out.println(c);
        } while(password.length() < passwordLength);
        // output the completed password
        if(password.length() > 0)
            System.out.printf("Your password is: %s\n", password);
        else
            System.out.println("You did not generate a password");
    }
}