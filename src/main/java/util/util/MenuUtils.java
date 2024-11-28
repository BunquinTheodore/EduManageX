//Made this file within the package of util
package util;

//Imported needed packages and classes
import java.util.Scanner;
import model.School;
import model.Student;
import model.Teacher;

public class MenuUtils {
    private static SchoolManager schoolManager = new SchoolManager();
    
//Registration Menu for both Teachers and Students
    public static void registerMenu(Scanner scanner, School school) {
        System.out.println("\n\n=======================================================");
        System.out.println("             R E G I S T E R   M E N U");
        System.out.println("=======================================================");
        System.out.println(" 1. Register as Student");
        System.out.println(" 2. Register as Teacher");
        System.out.println("-------------------------------------------------------");
        System.out.print(" Enter your choice: ");
        
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please enter a number.");
            return;
        }
        if (choice == 1) {
            registerStudent(scanner, school);
            
        }
        else if (choice == 2) {
            registerTeacher(scanner, school);
        }
        else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    //Student Registration
    private static void registerStudent(Scanner scanner, School school) {
        System.out.println("\n=======================================================");
        System.out.println("        S T U D E N T   R E G I S T R A T I O N");
        System.out.println("=======================================================");
        System.out.print(" Enter Student ID (at least 8 characters): ");
        String id = scanner.nextLine();
        System.out.print(" Enter Password (at least 8 characters): ");
        String password = scanner.nextLine();
        System.out.print(" Enter Name: ");
        String name = scanner.nextLine();

        if (school.getStudentById(id) != null || school.getTeacherById(id) != null) {
            System.out.println("  ID already exists. Please use a unique ID.");
            return;
        }

        //Dictates that the ID and password must be greater than or equal to 8 characters
        if (id.length() >= 8 && password.length() >= 8) {
            Student student = new Student(id, password, name);
            school.addStudent(student);
            schoolManager.registerStudent(id, password);  
            System.out.println("Student registered successfully.");
        }
        else {
            System.out.println("ID and Password must be at least 8 characters.");
        }
    }

    //Teacher Registration Menu
    private static void registerTeacher(Scanner scanner, School school) {
        System.out.println("\n=======================================================");
        System.out.println("        T E A C H E R   R E G I S T R A T I O N");
        System.out.println("=======================================================");
        System.out.print("  Enter Teacher ID (at least 8 characters): ");
        String id = scanner.nextLine();
        System.out.print("  Enter Password (at least 8 characters): ");
        String password = scanner.nextLine();
        System.out.print("  Enter Name: ");
        String name = scanner.nextLine();

        if (school.getStudentById(id) != null || school.getTeacherById(id) != null) {
            System.out.println("  ID already exists. Please use a unique ID.");
            return;
        }

        //Dictates that the ID and password must be greater than or equal to 8 characters
        if (id.length() >= 8 && password.length() >= 8) {
            Teacher teacher = new Teacher(id, password, name);  
            school.addTeacher(teacher);
            schoolManager.registerTeacher(id, password);  
            System.out.println("  Teacher registered successfully.");
        } else {
            System.out.println("  ID and Password must be at least 8 characters.");
        }
    }

    //Login Menu
    public static void loginAccount(Scanner scanner, School school) {
        MenuUtils.clearScreen();
        System.out.println("\n=======================================================");
        System.out.println("                 L O G I N   M E N U");
        System.out.println("=======================================================");
        System.out.print("  Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("  Enter Password: ");
        String password = scanner.nextLine();

        //Checks if ID exist, then checks if password is correct for both teacher and student
        if (schoolManager.isStudentLoginValid(id, password)) {
            System.out.println("Student login successful.");
            Student student = school.getStudentById(id);
            if (student != null) {
                studentMenu(scanner, student);
            }
        } else if (schoolManager.isTeacherLoginValid(id, password)) {
            System.out.println("  Teacher login successful.");
            Teacher teacher = school.getTeacherById(id);
            if (teacher != null) {
                teacherMenu(scanner, teacher);
            }
        } else {
            System.out.println("  Login failed. Invalid ID or Password.");
        }
    }

    //Student Menu
    private static void studentMenu(Scanner scanner, Student student) {
        while (true) {
            System.out.println("\n=======================================================");
            System.out.println("                 S T U D E N T   M E N U");
            System.out.println("=======================================================");
            System.out.println(" 1. Show ID");
            System.out.println(" 2. Enroll");
            System.out.println(" 3. Top-up Account");
            System.out.println(" 4. Pay Tuition");
            System.out.println(" 5. Show Liabilities");
            System.out.println(" 6. View Wallet");
            System.out.println(" 7. Show Grade");
            System.out.println(" 8. Scholarship");
            System.out.println(" 9. Back");
            System.out.println("-------------------------------------------------------");
            System.out.print(" Enter your choice: ");
        
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("  Invalid choice. Please enter a number.");
                continue;
            }
    
            switch (choice) {
                case 1:
                    student.showID();
                    break;
                case 2:
                    student.enroll(scanner);
                    break;
                case 3:
                    //Lets the user input any value which will be added to the wallet
                    System.out.print("Enter top-up amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    student.topUp(amount);
                    break;
                case 4:
                    student.payTuition(scanner);
                    break;
                case 5:
                    student.showLiabilities();
                    break;
                case 6:
                    student.viewWallet(); 
                    break;
                case 7:
                    student.showGrade();
                    break;
                case 8: 
                    student.applyScholarship();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    //Teacher Menu
    private static void teacherMenu(Scanner scanner, Teacher teacher) {
        while (true) {
            System.out.println("\n=======================================================");
            System.out.println("                   T E A C H E R   M E N U");
            System.out.println("=======================================================");
            System.out.println(" 1. Enter Position");
            System.out.println(" 2. View Salary");
            System.out.println(" 3. View Balance");
            System.out.println(" 4. View Wallet");
            System.out.println(" 5. Withdraw Salary");
            System.out.println(" 6. View ID");
            System.out.println(" 7. Choose Department/Year Level");
            System.out.println(" 8. Back");
            System.out.println("-------------------------------------------------------");
            System.out.print(" Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        teacher.enterPosition(scanner, teacher);
                        break;
                    case 2:
                        teacher.viewSalary(teacher);
                        break;
                    case 3:
                        teacher.viewBalance(teacher);
                        break;
                    case 4:
                        teacher.viewWallet();
                        break;
                    case 5:
                        teacher.withdrawSalary(scanner);
                        break;
                    case 6:
                        teacher.showID();
                        break;
                    case 7:
                        teacher.assignDepartmentAndYear(scanner, teacher);
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    //Clears console after the process
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
