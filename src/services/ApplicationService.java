package services;

import entities.Applicant;
import entities.Job;

/**
 * Service class to manage job applications.
 */
public class ApplicationService {

    public void applyForJob(Applicant applicant, Job job) {
        System.out.println(applicant.getName() + " has applied for the job: " + job.getTitle() + " at " + job.getCompany());
    }
}
