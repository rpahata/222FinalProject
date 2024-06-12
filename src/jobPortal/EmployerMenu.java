package jobPortal;

import java.util.Scanner;

public class EmployerMenu {
	public static void displayMenu() {
		System.out.println("Welcome to the Employer Menu\n"
				+ "1. Post a Job\n"
				+ "2. View posted jobs\n"
				+ "3. Update Job Postings\n"
				+ "Exit");
	}
	
	public void postJob() {
		System.out.println("Posting a new job");	
	}
	
	public void viewPostedJobs() {
		System.out.println("Viewing posted jobs");
	}
}
