import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpensesTrack {

	private static List<Expenses> expList = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	private static boolean isRunning = true;
	
	
	public static void main(String[] args) {
		
		
		while(isRunning) {
			System.out.println("Expenses Tracker Menu : \n");
			System.out.println("Press 1 to Add Expenses");
			System.out.println("Press 2 to View Expenses");
			System.out.println("Press 3 to Exit");
			
			System.out.println("\nEnter your Choice : ");
			int choice = scan.nextInt();
			scan.nextLine(); // consume the new line character
			
			switch(choice) {
				case 1:
					addExpenses();
					break;
				case 2:
					viewExpenses();
					break;
				case 3:
					isRunning = false;
					break;
				default:
					System.out.println("Invalid input. Please try again");
			}
			
		}
		System.out.println("Expenses tracker closed !!!");

	}
	
	public static void addExpenses() {
		
		System.out.println("Add a description: ");
		String description = scan.nextLine();
		
		System.out.println("Enter the amount : ");
		double amount = scan.nextInt();
		
		Expenses expAdding = new Expenses(description, amount);
		expList.add(expAdding);
		
		System.out.println("New Expnses Added !!!");
	}
	
	public static void viewExpenses() {
		if(expList.isEmpty()) {
			System.out.println("There are no entries : #########");
			isRunning =false;
		}
		
		System.out.println("\n Expenses list : ");
		System.out.printf("%-20s%-10s\n", "Description" , "Amount");
		System.out.printf("%-20s%-10s\n", "------------" , "-------");
		
		expList.forEach(listItems -> System.out.printf("%-20s%-10.2f\n", listItems.description, listItems.amount));
		
		double totalAmount = expList.stream().mapToDouble(e -> e.amount).sum();
		System.out.println("\nTotal amount is : " + totalAmount);
		System.out.printf("%-20s%-10s\n", "------------" , "-------");
		
		isRunning = false;
	}
	

}

class Expenses{
	
	String description;
	double amount;
	
	
	public  Expenses(String description, double amount2) {
		
		this.description = description;
		this.amount = amount2;
	}
}
