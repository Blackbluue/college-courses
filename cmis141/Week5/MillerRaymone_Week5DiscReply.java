import java.util.Scanner;
import java.util.InputMismatchException;

class MillerRaymone_Week5DiscReply {
  static void fibonacci(int count) {
    Scanner input = new Scanner(System.in);
    int current=0,previous=1,next, iterations=-1;    
    System.out.printf("first term: %s\nsecond term: %s\n",current, previous);//printing 0 and 1    
    
    for(int i=2;i<count;++i) {    
      next=current+previous;    
      System.out.printf("iteration %s:  %s\n", iterations+i, next);
      System.out.print("Calculate ratio? y/n ");
      char getRatio = input.nextLine().charAt(0);
      if(getRatio == 'y')
        System.out.printf("\tCurrent ratio: %f\n", (double) next / previous);
      current=previous;
      previous=next;
    }
    input.close();
  }
  
  static void getInput() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a positive number: ");
    int num;
    // sentinal value to control while-loop
    boolean badInput = true;

    while(badInput) {
      /* Simple check for input given a number  */
      try {
        num = input.nextInt();
        if(isPositive(num)) {
          fibonacci(num);
          input.close();
          // input good, change sentinal value
          badInput = false;
        }
      } catch(InputMismatchException e) {
        // if not, ask for a new number
        System.out.print("Please enter a whole number: ");
        input.nextLine();  // clears input buffer of bad input
        // check the num again and again and again!
      }
    }
  }
  
  static boolean isPositive(int num) {
    if (num < 0) {
      System.out.print("Please enter a positive integer.\n");
      return false;
    }
    return true;
  }

  public static void main (String[] args){
    System.out.print("Fibonacci Sequence🌀\n");
    getInput();
  }
}