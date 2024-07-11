import java.util.ArrayList;
import java.util.List;

public class Developer {
    private String name;
    private int age;
    private List<String> programmingLanguages;
    private int experienceYears;
    private String currentProject;

    public Developer() {
        this.programmingLanguages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number.");
        }
        this.age = age;
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void addProgrammingLanguage(String language) {
        if (language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Programming language cannot be null or empty.");
        }
        this.programmingLanguages.add(language);
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience years cannot be negative.");
        }
        this.experienceYears = experienceYears;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        if (currentProject == null || currentProject.isEmpty()) {
            throw new IllegalArgumentException("Cannot be null or empty.");
        }
        this.currentProject = currentProject;
    }

    public void displayDeveloperInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Programming Languages: " + this.programmingLanguages);
        System.out.println("Experience Years: " + this.experienceYears);
        System.out.println("Current Project: " + this.currentProject);
    }

    public static void main(String[] args) {
        Developer dev = new Developer();
        dev.setName("Daniel Remel");
        dev.setAge(23);
        dev.addProgrammingLanguage("Java");
        dev.addProgrammingLanguage("Python");
        dev.addProgrammingLanguage("C");
        dev.addProgrammingLanguage("C++");
        dev.setExperienceYears(2);
        dev.setCurrentProject("Restaurant Management System");
        dev.displayDeveloperInfo();
    }
}
