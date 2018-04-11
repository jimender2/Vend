//Needed for the program
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Jonathan Meredith
 * This program acts as a virtual vending machine. It loads items from a file
 * and then it asks the user questions in order to allow them to buy things.
 * I do realize that this is long and could be more efficient. I wanted to use 
 * a few things that made it that way.
 */
public class Vend {

	public static void main(String[] args) throws IOException {
		
		//Declare all of my variables
		boolean again = false;
		
		String itemOne,
			itemTwo,
			itemThree,
			itemFour,
			itemFive,
			user,
			choice;
		
		float costOne,
			costTwo,
			costThree,
			costFour,
			costFive;
		
		int money = 0;
		
		//Prep Human Scanner
		Scanner scan = new Scanner(System.in);
		
		//Prep File Scanner
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
    
    	//Close file input
    	input.close();
    	
    	//Allow repeating of the vending machine
		do {
			
			//Welcome and display all of the products available
			System.out.println("Welcome to the virtual vending machine."
				+ "  It serves:\n");
	    	System.out.printf("1: %-20s $%.2f \n", itemOne, costOne);
	    	System.out.printf("2: %-20s $%.2f \n", itemTwo, costTwo);
	    	System.out.printf("3: %-20s $%.2f \n", itemThree, costThree);
	    	System.out.printf("4: %-20s $%.2f \n", itemFour, costFour);
	    	System.out.printf("5: %-20s $%.2f \n", itemFive, costFive);
		
	    	//Get the users money
	    	money = getMoney(scan);
		
	    	//Get what item the user wants
	    	choice = userChoice(scan);
		
	    	//Calculate cost of item and see if the user has enough money
	    	//Different options based on what they want
	    	switch (choice) {
	    		case "1":
	    			calculateCost(money, itemOne, costOne);
	    			break;
	    		case "2":
	    			calculateCost(money, itemTwo, costTwo);
	    			break;
	    		case "3":
	    			calculateCost(money, itemThree, costThree);
	    			break;
	    		case "4":
	    			calculateCost(money, itemFour, costFour);
					break;
	    		case "5":
	    			calculateCost(money, itemFive, costFive);
	    			break;
	    		default:
	    			break;
	    	}
	    	
	    	//See if they want to buy something else
	    	System.out.println("Would you like to make another purchase? "
	    			+ "(y/n)");
	    	
	    	//clear input buffer
	    	scan.nextLine();
	    	
	    	//get choice
	    	user = scan.nextLine();
	    	user = user.toLowerCase();
	    	
	    	//decide if you want to continue
	    	switch (user) {
	    		case "y":
	    			again = true;
	    			break;
	    		case "n":
	    			again = false;
	    			break;
	    		default:
	    			again = false;
	    	}
	    	
	    //continue??
		} while (again);
		
		//close human scanner
		scan.close();
	}
	
	/**
	 * 
	 * @param changeMoney Pass the amount of money that the user inputed to be
	 * used later in the function after it is converted to a double
	 * @param item Pass what item they want to get so that it can be displayed
	 * @param cost Pass how much the item costs so that it can be subtracted
	 * later
	 */
	public static void calculateCost(int changeMoney, String item, float cost) {
		
		//Declare variables
		int	quarters,
			dimes,
			pennies,
			change;
		
		double money;
		
		//convert money to a double
		money = (changeMoney + 0.0) / 100;
		
		//see if the thing the user wants to buy is less than the money they 
		//added
		if (money < cost) {
			System.out.println("You entered insufficient funds to purchase "
					+ "the " + item + ".");
		} else {
			//calculate how much change they would get
			money = money - cost;			
		}
		
		//convert change to a int (much easier to divide)
		change = (int) (money * 100);
		
		//call findChange to get number of quarters, dimes, and pennies
		quarters = findChange(change, 25);
		dimes = findChange(change, 10);
		pennies = findChange(change, 1);
		
		//Print how much change you get
		System.out.println("I have returned " + quarters + " quarters, "
				+ dimes + " dimes, " + pennies + " pennies to you.");
		
	}
	
	/**
	 * 
	 * @param money
	 * @param denomination
	 * @return
	 */
	public static int findChange(int money, int denomination) {
		
		//Declare variables
		int quarters,
			dimes,
			pennies;
		
		//Quarters
		quarters = (money / 25);
		
		//Remaining change
		money = money - (quarters * 25);
		
		//Dimes
		dimes = (money / 10);

		//Remaining change
		money = money - (dimes * 10);
		
		//Pennies
		pennies = (money / 1);
		
		//Choose what to return
		if (denomination == 25) {
			return quarters;
		} else if (denomination == 10) {
			return dimes;
		} else if (denomination == 1) {
			return pennies;
		}
		
		//This should never execute
		return money;
	}
	
	/**
	 * 
	 * @param scan Pass in the scanner object so we do not have to recreate it
	 * @return user choice in string form for which choice they want. I did 
	 * this because I wanted to use a switch statement later
	 */
	public static String userChoice (Scanner scan) {
		
		//Declare variables
		int choiceFromUser;
		
		String choice = "e";
		
		//Get user choice
		System.out.print("Please enter your selection: ");
		choiceFromUser = scan.nextInt();
		System.out.println("");
		
		//Make sure choice is valid
		while ((choiceFromUser > 5) || (choiceFromUser < 1)) {
			System.out.println("Please enter a valid choice (1-5): ");
			choiceFromUser = scan.nextInt();
		}
		
		//Choose what to return and put it as a string
		if (choiceFromUser == 1) {
			choice = "1";
			return choice;
		} else if (choiceFromUser == 2) {
			choice = "2";
			return choice;
		} else if (choiceFromUser == 3) {
			choice = "3";
			return choice;
		} else if (choiceFromUser == 4) {
			choice = "4";
			return choice;
		} else if (choiceFromUser == 5) {
			choice = "5";
			return choice;
		}
		
		//This should never execute
		return choice;
	}
	
	/**
	 * 
	 * @param scan Pass in the scanner object so we do not have to recreate it
	 * @return Return the amount of money back to the main method as an integer
	 */
	public static int getMoney (Scanner scan) {
		
		//Declare variables
		int money;
		
		//Get how much money the user wants to deposit
		System.out.println("");
		System.out.print("Please enter the amount of money "
				+ "deposited (in dollars) : $");
		
		//Get and convert to int
		money = (int) (scan.nextFloat() * 100);
		System.out.println("");
		return money;
	}
}