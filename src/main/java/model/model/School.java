package model;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private double totalFunds;    // Added to track total funds
    private double totalSalaries; // Added to track total salaries

    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.totalFunds = 0.0;
        this.totalSalaries = 0.0;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Retrieves a Student object based on their ID
    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; // Return null if no student with the given ID is found
    }

    // Retrieves a Teacher object based on their ID
    public Teacher getTeacherById(String id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null; // Return null if no teacher with the given ID is found
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public void displaySchoolSummary() {
        totalFunds = 0.0;
        
        // Header for Student Tuition Summary
        System.out.println("========================================================================================================");
        System.out.println("                                      STUDENT TUITION SUMMARY              ");
        System.out.println("========================================================================================================");
    
        // Display each student's tuition summary
        for (Student student : students) {
            double studentPaidTuition = student.getTotalPaidTuition();
            String studentInfo = String.format(" Student ID: %-10s | Tuition Paid: $%-10.2f", student.getId(), studentPaidTuition);
            System.out.println(studentInfo);
            totalFunds += studentPaidTuition;
        }
    
        totalSalaries = 0.0;
    
        // Header for Teacher Salary Summary
        System.out.println("\n========================================================================================================");
        System.out.println("                                      TEACHER SALARY SUMMARY                 ");
        System.out.println("========================================================================================================");
    
        // Display each teacher's salary summary
        for (Teacher teacher : teachers) {
            double teacherBaseSalary = teacher.getBaseSalary();
            String teacherInfo = String.format(" Teacher ID: %-10s | Position: %-20s | Salary: $%-10.2f",
                                                teacher.getId(), teacher.getPosition(), teacherBaseSalary);
            System.out.println(teacherInfo);
            totalSalaries += teacherBaseSalary;
        }
    
        // Header for Financial Summary
        System.out.println("\n========================================================================================================");
        System.out.println("                                         FINANCIAL SUMMARY                ");
        System.out.println("========================================================================================================");
    
        // Display financial summary with calculations
        String totalFundsInfo = " Total Tuition Funds:               $" + String.format("%.2f", totalFunds);
        String totalSalariesInfo = " Total Teacher Salaries:            $" + String.format("%.2f", totalSalaries);
        String netIncomeInfo = " Net Income (Funds - Salaries):     $" + String.format("%.2f", (totalFunds - totalSalaries));
        
        System.out.println(totalFundsInfo);
        System.out.println(totalSalariesInfo);
        System.out.println(netIncomeInfo);
        System.out.println("====================================================\n");
    }
    
}

