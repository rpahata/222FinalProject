package jobPortal;

import java.util.Scanner;

public class JobSearcherMenu {

	public static void displayMenu() {
		System.out.println("Welcome to the Job Searcher Menu\n"
				+ "1. Search for Jobs\n"
				+ "2. View Applied Jobs\n"
				+ "3. Update Profile\n"
				+ "4. Exit");
	}
	Scanner scanner=new Scanner(System.in);
	int choice = scanner.nextInt();
	
	  
}
