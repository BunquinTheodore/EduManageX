package model;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private double totalFunds;    
    private double totalSalaries; 

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

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; 
    }

    public Teacher getTeacherById(String id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null; 
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public void displaySchoolSummary() {
        totalFunds = 0.0;
        System.out.println("========================================================================================================");
        System.out.println("                                      STUDENT TUITION SUMMARY              ");
        System.out.println("========================================================================================================");
    
        for (Student student : students) {
            double studentPaidTuition = student.getTotalPaidTuition();
            String studentInfo = String.format(" Student ID: %-10s | Tuition Paid: $%-10.2f", student.getId(), studentPaidTuition);
            System.out.println(studentInfo);
            totalFunds += studentPaidTuition;
        }
    
        totalSalaries = 0.0;
    
        System.out.println("\n========================================================================================================");
        System.out.println("                                      TEACHER SALARY SUMMARY                 ");
        System.out.println("========================================================================================================");
    
        for (Teacher teacher : teachers) {
            double teacherBaseSalary = teacher.getBaseSalary();
            String teacherInfo = String.format(" Teacher ID: %-10s | Position: %-20s | Salary: $%-10.2f",
                                                teacher.getId(), teacher.getPosition(), teacherBaseSalary);
            System.out.println(teacherInfo);
            totalSalaries += teacherBaseSalary;
        }
    
        System.out.println("\n========================================================================================================");
        System.out.println("                                         FINANCIAL SUMMARY                ");
        System.out.println("========================================================================================================");

        String totalFundsInfo = " Total Tuition Funds:               $" + String.format("%.2f", totalFunds);
        String totalSalariesInfo = " Total Teacher Salaries:            $" + String.format("%.2f", totalSalaries);
        String netIncomeInfo = " Net Income (Funds - Salaries):     $" + String.format("%.2f", (totalFunds - totalSalaries));
        
        System.out.println(totalFundsInfo);
        System.out.println(totalSalariesInfo);
        System.out.println(netIncomeInfo);
        System.out.println("====================================================\n");
    }
    
}

