import java.io.*;
import java.util.Scanner;


public class Vend {

	public static void main(String[] args) throws IOException {
		
		//Declare variables
		String itemOne,
			itemTwo,
			itemThree,
			itemFour,
			itemFive;
		
		float costOne,
			costTwo,
			costThree,
			costFour,
			costFive;
		
		//Prep Scanner
		File file = new File("stock.txt");
		Scanner input = new Scanner(file);
	    
	    //Get names and cost of items
	    itemOne = input.nextLine();
	    costOne = input.nextFloat();
	    input.nextLine();
	    itemTwo = input.nextLine();
	    costTwo = input.nextFloat();
	    input.nextLine();
	    itemThree = input.nextLine();
	    costThree = input.nextFloat();
	    input.nextLine();
	    itemFour = input.nextLine();
	    costFour = input.nextFloat();
	    input.nextLine();
	    itemFive = input.nextLine();
	    costFive = input.nextFloat();
	    
	    //Close input
		input.close();
		
		System.out.println("1: " + itemOne + " $" + costOne);
		System.out.println("2: " + itemTwo + " $" + costTwo);
		System.out.println("3: " + itemThree + " $" + costThree);
		System.out.println("4: " + itemFour + " $" + costFour);
		System.out.println("5: " + itemFive + " $" + costFive);
	}
	
	
}
