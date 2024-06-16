package ui;

import services.ApplicationService;
import services.JobService;
import services.UserService;

import java.util.Scanner;

/**
 * Main class for the Job Portal application.
 * Provides menus for job searchers and employers to interact with the system.
 */
public class JobPortalApp {

    private static JobService jobService = new JobService();
    private static ApplicationService applicationService = new ApplicationService();
    private static JobSearcherMenu jobSearcherMenu = new JobSearcherMenu(jobService, applicationService);
    private static EmployerMenu employerMenu = new EmployerMenu(jobService);
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Job Portal");

        // Main menu loop
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Job Searcher Menu");
            System.out.println("2. Employer Menu");
            System.out.println("3. Login");
            System.out.println("4. Signup");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle user's choice using switch case
            switch (choice) {
                case 1:
                    jobSearcherMenu.displayMenu(scanner);
                    break;
                case 2:
                    employerMenu.displayMenu(scanner);
                    break;
                case 3:
                    System.out.println("Login selected"); // Debug message
                    userService.login();
                    break;
                case 4:
                    System.out.println("Signup selected"); // Debug message
                    userService.signUp();
                    break;
                case 5:
                    System.out.println("Exiting the Job Portal. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
