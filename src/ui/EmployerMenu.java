package ui;

import java.util.Scanner;

import entities.Job;
import services.JobService;
/**
 * Handles the employer menu functionalities.
 */




import java.util.Scanner;

/**
 * Handles the employer menu functionalities.
 */
public class EmployerMenu {

    private JobService jobService;

    public EmployerMenu(JobService jobService) {
        this.jobService = jobService;
    }

    /**
     * Displays the employer menu and handles user input.
     *
     * @param scanner The Scanner object for reading user input.
     */
    public void displayMenu(Scanner scanner) {
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\nEmployer Menu:");
            System.out.println("1. Post a New Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            // Check if the next token is an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Validate the range of input
                if (choice >= 1 && choice <= 3) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        // Process user choice
        switch (choice) {
            case 1:
                postNewJob(scanner);
                break;
            case 2:
                jobService.listAllJobs();
                break;
            case 3:
                System.out.println("Logging out from Employer Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
    }

    /**
     * Prompts the employer to post a new job.
     *
     * @param scanner The Scanner object for reading user input.
     */
    private void postNewJob(Scanner scanner) {
        System.out.println("\nPosting a New Job:");
        System.out.print("Enter job title: ");
        String title = scanner.nextLine();
        System.out.print("Enter company name: ");
        String company = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Job newJob = new Job(title, company, salary);
        jobService.addJob(newJob);

        System.out.println("Job posted successfully:");
        System.out.println(newJob);
    }
}
