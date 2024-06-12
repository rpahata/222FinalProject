package jobPortal;

import java.util.Scanner;

public class JobPortal {
	public static void main (String[] args) {
		//Output welcome message
		System.out.println("Welcome to Job Portal\n"
				+ "1. Job Searcher Menu\n"
				+ "2. Employer Menu");
		
		//Create a Scanner object for user input
		Scanner scanner=new Scanner(System.in);
		
		//read user's choice
		int choice = scanner.nextInt();
		
		//uses if-else to determine the menu
		if (choice==1) {
			JobSearcherMenu.displayMenu();
		} else if(choice ==2) {
			EmployerMenu.displayMenu();
		} else {
			System.out.println("Invalid choice. Please type 1 or 2.");
		}
		
		//Close the scanner
		scanner.close();
	}
}
