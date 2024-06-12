package jobPortal;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class SignUpSystem {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String phoneNumber;

    // Constructor 1: No-arg constructor
    public SignUpSystem() {}

    // Constructor 2: Parameterized constructor
    public SignUpSystem(String username, String password, String confirmPassword, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Method to validate username
    private boolean validateUsername(String username) {
        if (username.length() < 6) {
            return false;
        }
        return true;
    }

    // Method to validate password
    private boolean validatePassword(String password, String confirmPassword) {
        if (password.length() < 8) {
            return false;
        }
        if (!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }

    // Method to validate email
    private boolean validateEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        return true;
    }

    // Method to validate phone number
    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            return false;
        }
        return true;
    }

    // Method to sign up
    public void signUp() {
        Scanner scanner = new Scanner(System.in);

        // Get username
        while (true) {
            String inputUsername = JOptionPane.showInputDialog("Enter username:");
            if (validateUsername(inputUsername)) {
                username = inputUsername;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username must be at least 6 characters long.");
            }
        }

        // Get password
        while (true) {
            String inputPassword = JOptionPane.showInputDialog("Enter password:");
            String inputConfirmPassword = JOptionPane.showInputDialog("Confirm password:");
            if (validatePassword(inputPassword, inputConfirmPassword)) {
                password = inputPassword;
                confirmPassword = inputConfirmPassword;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long and match the confirmation.");
            }
        }

        // Get email
        while (true) {
            String inputEmail = JOptionPane.showInputDialog("Enter email:");
            if (validateEmail(inputEmail)) {
                email = inputEmail;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email address.");
            }
        }

        // Get phone number
        while (true) {
            String inputPhoneNumber = JOptionPane.showInputDialog("Enter phone number:");
            if (validatePhoneNumber(inputPhoneNumber)) {
                phoneNumber = inputPhoneNumber;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid phone number.");
            }
        }

        // Display sign-up success message
        JOptionPane.showMessageDialog(null, "Sign-up successful!");
    }

    // Method to display sign-up form
    public void displaySignUpForm() {
        signUp();
    }

    public static void main(String[] args) {
        SignUpSystem signUpSystem = new SignUpSystem();
        signUpSystem.displaySignUpForm();
    }
}

// Subclass: JobSeeker
class JobSeeker extends SignUpSystem {
    private String resume;

    // Constructor
    public JobSeeker(String username, String password, String confirmPassword, String email, String phoneNumber, String resume) {
        super(username, password, confirmPassword, email, phoneNumber);
        this.resume = resume;
    }

    // Method to upload resume
    public void uploadResume() {
        // TO DO: Implement resume upload logic
        JOptionPane.showMessageDialog(null, "Resume uploaded successfully!");
    }
}

// Subclass: Employer
class Employer extends SignUpSystem {
    private String company;

    // Constructor
    public Employer(String username, String password, String confirmPassword, String email, String phoneNumber, String company) {
        super(username, password, confirmPassword, email, phoneNumber);
        this.company = company;
    }

    // Method to post job
    public void postJob() {
        // TO DO: Implement job posting logic
        JOptionPane.showMessageDialog(null, "Job posted successfully!");
    }
}
