package entities;
/**
 * Represents a job applicant.
 */
public class Applicant {
    private String name;
    private String email;
    private String skills;

    public Applicant(String name, String email, String skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
