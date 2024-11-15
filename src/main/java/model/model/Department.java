package model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Course> courses;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

