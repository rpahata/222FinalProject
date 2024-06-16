package ui;

import java.util.List;
import java.util.Scanner;

import entities.Applicant;
import entities.Job;
import services.ApplicationService;
import services.JobService;

/**
 * Handles the job searcher menu functionalities.
 */
public class JobSearcherMenu {

    private JobService jobService;
    private ApplicationService applicationService;

    public JobSearcherMenu(JobService jobService, ApplicationService applicationService) {
        this.jobService = jobService;
        this.applicationService = applicationService;
    }

    /**
     * Displays the job searcher menu and handles user input.
     *
     * @param scanner The Scanner object for reading user input.
     */
    public void displayMenu(Scanner scanner) {
        int choice;
        System.out.println("Job Searcher Menu:");
        System.out.println("1. Search for Jobs");
        System.out.println("2. Apply for a Job");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            searchJobs(scanner);
        } else if (choice == 2) {
            applyForJob(scanner);
        } else if (choice == 3) {
            return; // Go back to main menu
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Prompts the user to search for jobs by title or company.
     *
     * @param scanner The Scanner object for reading user input.
     */
    private void searchJobs(Scanner scanner) {
        System.out.print("Enter job title or company to search: ");
        String criteria = scanner.nextLine();

        List<Job> matchingJobs = jobService.searchJobs(criteria);
        if (matchingJobs.isEmpty()) {
            System.out.println("No matching jobs found.");
        } else {
            System.out.println("Matching Jobs:");
            for (Job job : matchingJobs) {
                System.out.println(job.getTitle() + " at " + job.getCompany() + ", Salary: " + job.getSalary());
            }
        }
    }

    /**
     * Prompts the user to apply for a job.
     *
     * @param scanner The Scanner object for reading user input.
     */
    private void applyForJob(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your skills: ");
        String skills = scanner.nextLine();

        Applicant applicant = new Applicant(name, email, skills);

        System.out.print("Enter the job title you want to apply for: ");
        String jobTitle = scanner.nextLine();

        Job jobToApply = null;
        for (Job job : jobService.searchJobs(jobTitle)) {
            if (job.getTitle().equalsIgnoreCase(jobTitle)) {
                jobToApply = job;
                break;
            }
        }

        if (jobToApply != null) {
            applicationService.applyForJob(applicant, jobToApply);
        } else {
            System.out.println("Job not found.");
        }
    }
}
