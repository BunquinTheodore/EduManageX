// Define the package
package model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    // Declare the name of the department
    private String name;
    // Declare the list to hold courses in the department
    private List<Course> courses;

    // Constructor to initialize the department with a name
    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Getter method to get the name of the department
    public String getName() {
        return name;
    }

    // Getter method to get the list of courses in the department
    public List<Course> getCourses() {
        return courses;
    }
}
