import java.util.Scanner;
public class Reply_Week5Discussion {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = (long) input(sc);
        System.out.println(number);
    }

    public static double input(Scanner sc) {
        return sc.nextDouble();
    }
}
