package services;

import javax.swing.JOptionPane;

/**
 * Service class for managing user-related operations.
 */
public class UserService {

    // Arrays to store user information
    private String[] jobSeekerUsernames = new String[100];
    private String[] jobSeekerEmails = new String[100];
    private String[] jobSeekerPasswords = new String[100];
    private int jobSeekerCount = 0;

    private String[] employerUsernames = new String[100];
    private String[] employerEmails = new String[100];
    private String[] employerPasswords = new String[100];
    private int employerCount = 0;

    /**
     * Sign up a new user as either a job seeker or an employer.
     */
    public void signUp() {
        // Prompt user to choose account type
        String[] options = {"Employer", "Job Seeker"};
        int choice = JOptionPane.showOptionDialog(null, 
                "Are you signing up as an Employer or Job Seeker?", 
                "Signup", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]);

        // If user closes the dialog
        if (choice == JOptionPane.CLOSED_OPTION) {
            System.out.println("Signup dialog closed by user"); // Debug message
            return;
        }

        // Get user input
        String username = JOptionPane.showInputDialog(null, "Enter username:", "Signup", JOptionPane.QUESTION_MESSAGE);
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Signup failed: empty username"); // Debug message
            return;
        }

        String email = JOptionPane.showInputDialog(null, "Enter email:", "Signup", JOptionPane.QUESTION_MESSAGE);
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Signup failed: empty email"); // Debug message
            return;
        }

        String password = JOptionPane.showInputDialog(null, "Enter password:", "Signup", JOptionPane.QUESTION_MESSAGE);
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Signup failed: empty password"); // Debug message
            return;
        }

        if (choice == 0) {
            // Register as Employer
            employerUsernames[employerCount] = username;
            employerEmails[employerCount] = email;
            employerPasswords[employerCount] = password;
            employerCount++;
            JOptionPane.showMessageDialog(null, "Employer registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Employer registered: " + username); // Debug message
        } else if (choice == 1) {
            // Register as Job Seeker
            jobSeekerUsernames[jobSeekerCount] = username;
            jobSeekerEmails[jobSeekerCount] = email;
            jobSeekerPasswords[jobSeekerCount] = password;
            jobSeekerCount++;
            JOptionPane.showMessageDialog(null, "Job Seeker registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Job Seeker registered: " + username); // Debug message
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Invalid choice in signup"); // Debug message
        }
    }

    /**
     * Log in an existing user.
     *
     * @return True if login is successful, false otherwise.
     */
    public boolean login() {
        // Prompt user to choose account type
        String[] options = {"Employer", "Job Seeker"};
        int choice = JOptionPane.showOptionDialog(null, 
                "Are you logging in as an Employer or Job Seeker?", 
                "Login", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]);

        // If user closes the dialog
        if (choice == JOptionPane.CLOSED_OPTION) {
            System.out.println("Login dialog closed by user"); // Debug message
            return false;
        }

        // Get user input
        String username = JOptionPane.showInputDialog(null, "Enter username:", "Login", JOptionPane.QUESTION_MESSAGE);
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Login failed: empty username"); // Debug message
            return false;
        }

        String password = JOptionPane.showInputDialog(null, "Enter password:", "Login", JOptionPane.QUESTION_MESSAGE);
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Login failed: empty password"); // Debug message
            return false;
        }

        if (choice == 0) {
            // Login as Employer
            for (int i = 0; i < employerCount; i++) {
                if (employerUsernames[i].equals(username) && employerPasswords[i].equals(password)) {
                    JOptionPane.showMessageDialog(null, "Employer login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Employer login successful: " + username); // Debug message
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Employer login failed. Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Employer login failed for: " + username); // Debug message
        } else if (choice == 1) {
            // Login as Job Seeker
            for (int i = 0; i < jobSeekerCount; i++) {
                if (jobSeekerUsernames[i].equals(username) && jobSeekerPasswords[i].equals(password)) {
                    JOptionPane.showMessageDialog(null, "Job Seeker login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Job Seeker login successful: " + username); // Debug message
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Job Seeker login failed. Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Job Seeker login failed for: " + username); // Debug message
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Invalid choice in login"); // Debug message
        }

        return false;
    }
}
