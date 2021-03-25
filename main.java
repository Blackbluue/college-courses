/** File: Reply_Week5Discussion.java
 * Elijah_Gordon
 * CMIS 141/6980
 * Reply to Discussion 5 Owen_Anthony
 * March 23, 2021
 * Description: This program has been altered to a timer that will count down from the value you choose
 * through input along with a multiplier of your choice to speed up the countdown procedure to the user's choice
 **/
//Import Scanner
import java.util.Scanner;
public class Reply_Week5Discussion {

	public static void main(String[] args) throws InterruptedException {

		//Declaration of variables 
		int numLoops, mult;
		
		//Scanner = input
		Scanner input = new Scanner(System.in);
		
		//System out print stating the instructions of the program
		System.out.println("This is a timer and will count down from the number you enter. ");
		System.out.println("\nPlease enter the number in seconds you would like to countdown from: ");
		numLoops = input.nextInt();
		System.out.println("\nPlease enter the multiplier you wish to add onto the countdown: ");
		mult = input.nextInt();
		
		//Initialization stating input = starting number, condition stating continue to loop until value of 
		//i is equal to 0, update stating decrement by 1 each loop.
		for(int i = numLoops; i >= 0; i++) {
			//One second delay for each second on the timer
			Thread.sleep(1000);
			
			//This will print how much time is left on the timer. 
			System.out.println("You have " + i*mult + " seconds left.");
			}
			//Letting the user know the timer is complete
		    System.out.println("\nYour countdown is complete. ");
		    
		//Close scanner
		input.close();}}
