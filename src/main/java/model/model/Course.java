// Define the package
package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    // Declare the name of the course
    private String name;
    // Declare the list to hold enrolled students
    private List<Student> enrolledStudents;

    // Constructor to initialize the course with a name
    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter method to get the name of the course
    public String getName() {
        return name;
    }

    // Getter method to get the list of enrolled students
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
