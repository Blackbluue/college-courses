/** Password Strength Calculator - Rod Daniels
 * Takes two variables. The size of the character set and the length of the
 * password and then compute bits of security based on the character space
 **/
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        // Create scanner object to read input
        Scanner inputObj = new Scanner(System.in);

        // Prompt for the length of the password
        System.out.println("Password Length:");
        int passwordLength = inputObj.nextInt();

        // Prompt for the key space used to create the password
        System.out.println("Key Space: (lower=26, upper/lower/digit/char=95)");
        int keySpace = inputObj.nextInt();

        // Possible combinations is space^length
        double combinations = (double)Math.pow(keySpace, passwordLength);

        // Calculate Log2(combinations) to determine bit representation
        // java log is Log10 so this is an indirect formula
        // LOGa(b) = Log10(b) / Log10(a)
        int result = (int)(Math.log(combinations) / Math.log(2));

        System.out.println("Your password has " + result + " bits of entropy.");
    }
}
