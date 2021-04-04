import java.util.*;

public class Week7Discussion {
	
	public static void multiplier(int list[], int times){

			list[0] = 1*times;
			list[1] = 2*times;
			list[2] = 3*times;
			list[3] = 4*times;
			list[4] = 5*times;		
	}
	
	public static void main(String[] args) {
		
/**File: Week7Discussion.java 

**Author: Elijah_Gordon
		
**Class: CMIS 141 � Week7Discussion
		
**Creation Date: April 1, 2021
		
**Description: This program was created specifically to allow a user to multiply an array of 5,
* by any number they choose through a method */
		
		Scanner scanint= new Scanner (System.in);
		
		int times = 0, choice,index = 0; 
		int[] list = {1,2,3,4,5};
		
		for (int answer = 0; answer < list.length;) {
			
		System.out.println("Welcome to the Array multiplier" );
		
		System.out.println("\nPlease enter the index you'd like to multiply:" );
		
		System.out.println("");
		index = scanint.nextInt();

		System.out.println("Please enter the number you would like to multipy the index by:" );
		
		System.out.println("");
		times = scanint.nextInt();
		
		multiplier (list,times);
		
		if (index == 1) {
		
System.out.println("\nYou selected Index:"+ " "+ index + ", " +"Multipilied by:"+ " "+ times+ " "+ "resulting in:" +" "+ list[0]);
					}
		
		if (index == 2) {
			
System.out.println("\nYou selected Index:"+ " "+ index + ", " +"Multipilied by:"+ " "+ times+ " "+ "resulting in:" +" "+ list[1]);	
					}	
		
		if (index == 3) {
			
System.out.println("\nYou selected Index:"+ " "+ index + ", " +"Multipilied by:"+ " "+ times+ " "+ "resulting in:" +" "+ list[2]);
										
					}	
		
		if (index == 4) {
			
System.out.println("\nYou selected Index:"+ " "+ index + ", " +"Multipilied by:"+ " "+ times+ " "+ "resulting in:" +" "+ list[3]);					
					}	
		
		if (index == 5) {
			
System.out.println("\nYou selected Index:"+ " "+ index + ", " +"Multipilied by:"+ " "+ times+ " "+ "resulting in:" +" "+ list[4]);
					}
		
System.out.println("\n\nIf you would like to end the program press 9, if not hit any other number to continue:" );
choice = scanint.nextInt();
		
		
//while (choice==9)

//scanint.close();

}
}
}



