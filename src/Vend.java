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
				
		int money = 0;
		
		String choice;
		
		//Prep Human Scanner
		Scanner scan = new Scanner(System.in);
		
		//Prep File Scanner
		File file = new File("stock.txt");
		Scanner input = new Scanner(file);
	    
		System.out.println("Welcome to the virtual vending machine."
				+ "  It serves:\n");
		
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
		
		System.out.printf("1: " + itemOne + " $" + costOne + "\n");
		System.out.printf("2: " + itemTwo + " $" + costTwo + "\n");
		System.out.printf("3: " + itemThree + " $" + costThree + "\n");
		System.out.printf("4: " + itemFour + " $" + costFour + "\n");
		System.out.printf("5: " + itemFive + " $" + costFive + "\n");
		
		//Get all of the users money. They dont need it.
		money = getMoney(scan);
		
		//Get what item the user wants. Make sure that they will eat 
		//it or I will shove it down their throat.
		choice = userChoice(scan);
		
		//Calculate cost of item and see if the user has enough money
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
		}
		
		//Test to make sure this is working
		
	}
	
	public static void calculateCost(int convertMoney, String item, float cost) {
		float money;
		int changeMoney;
		money = convertMoney / 100;
		if (money < cost) {
			System.out.println("You entered insufficient funds to purchase "
					+ "the " + item + ".");
		} else {
			money = money - cost;			
		}
		
		changeMoney = money * 100;
		
		changeMoney = findChange(changeMoney, 25);
	}
	
	public static int findChange(int changeMoney, int denomination) {
		
		return change;
	}
	
	public static String userChoice (Scanner scan) {
		int choiceFromUser;
		String choice = "e";
		System.out.println("Please enter your selection: ");
		choiceFromUser = scan.nextInt();
		while ((choiceFromUser > 5) || (choiceFromUser < 1)) {
			System.out.println("Please enter a valid choice (1-5): ");
			choiceFromUser = scan.nextInt();
		}
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
		return choice;
	}
	
	public static int getMoney (Scanner scan) {
		int money;
		System.out.println("");
		System.out.println("Please enter the amount of money "
				+ "deposited (in dollars) : $");
		
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//GET HER TO SEE IF THIS IS OK
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		money = (int) (scan.nextFloat() * 100);
		return money;
	}
}
