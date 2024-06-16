package services;
import java.util.ArrayList;
import java.util.List;

import entities.Job;
/**
 * Service class for managing job-related operations.
 */
public class JobService {

    private List<Job> jobs;

    public JobService() {
        this.jobs = new ArrayList<>();
        // Dummy data initialization (for demonstration purposes)
        initializeDummyData();
    }

    /**
     * Initializes dummy data for jobs.
     * For demonstration purposes.
     */
    private void initializeDummyData() {
        addJob(new Job("Software Engineer", "Tech Company A", 80000.0));
        addJob(new Job("Marketing Manager", "Global Marketing Agency", 70000.0));
        addJob(new Job("Data Analyst", "Data Analytics Inc.", 75000.0));
    }

    /**
     * Adds a new job to the list of jobs.
     *
     * @param job The Job object representing the job to be added.
     */
    public void addJob(Job job) {
        jobs.add(job);
    }

    /**
     * Lists all jobs currently available.
     */
    public void listAllJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
        } else {
            System.out.println("All Jobs:");
            for (Job job : jobs) {
                System.out.println(job);
            }
        }
    }

    /**
     * Searches for jobs based on the specified criteria.
     *
     * @param criteria The search criteria (e.g., job title, company).
     * @return A list of Job objects matching the criteria.
     */
    public List<Job> searchJobs(String criteria) {
        List<Job> matchingJobs = new ArrayList<>();
        for (Job job : jobs) {
            // Perform case-insensitive search by job title or company
            if (job.getTitle().toLowerCase().contains(criteria.toLowerCase()) ||
                job.getCompany().toLowerCase().contains(criteria.toLowerCase())) {
                matchingJobs.add(job);
            }
        }
        return matchingJobs;
    }
}
