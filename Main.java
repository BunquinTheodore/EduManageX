import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("Welcome to the School Management System \n");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter Occupation: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            if (choice == 3) {
                break;
            }

            int id = getInputId(scanner);
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine(); // Use nextLine() to read the full name

            if (choice == 2) { // Student
                handleStudent(school, scanner, id, name);
            } else if (choice == 1) { // Teacher
                handleTeacher(school, scanner, id, name);
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
        printSchoolSummary(school);
    }

    private static int getInputId(Scanner scanner) {
        int id = 0;
        while (true) {
            System.out.print("Enter your ID: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left-over
                break;
            } else {
                System.out.println("Invalid input. Please enter a numeric ID.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return id;
    }

    private static void handleStudent(School school, Scanner scanner, int id, String name) {
        System.out.print("Enter your Grade: ");
        int grade = scanner.nextInt();
        Student student = new Student(id, name, grade);
        school.addStudent(student);

        System.out.print("Enter the fees you want to pay: ");
        int feesPaid = scanner.nextInt();
        student.updateFeesPaid(feesPaid);
        school.updateTotalMoneyEarned(feesPaid);

        System.out.println("Student added: " + student.getName() + ", Fees Paid: " + student.getFeesPaid());
        System.out.println("Successfully registered as a Student.");
        System.out.println("Remaining Balance to be Paid: " + student.getRemainingFees());
    }

    private static void handleTeacher(School school, Scanner scanner, int id, String name) {
        System.out.print("Enter your Salary: ");
        int salary = scanner.nextInt();
        Teacher teacher = new Teacher(id, name, salary);
        school.addTeacher(teacher);

        System.out.println("Teacher added: " + teacher.getName() + ", Salary: " + teacher.getSalary());
        System.out.println("Successfully registered as a Teacher.");
    }

    private static void printSchoolSummary(School school) {
        if (school.getTeachers().isEmpty() && school.getStudents().isEmpty()) {
            System.out.println("No teachers, no students.");
        } else {
            System.out.println("School Summary:");
            System.out.println("Total Money Earned: " + school.getTotalMoneyEarned());
            System.out.println("Total Money Spent: " + school.getTotalMoneySpent());

            System.out.println("Students in school: ");
            for (Student student : school.getStudents()) {
                System.out.println("ID: " + student.getID() + ", Name: " + student.getName() +
                        ", Grade: " + student.getGrade() + ", Fees Paid: " + student.getFeesPaid());
            }

            System.out.println("Teachers in school: ");
            for (Teacher teacher : school.getTeachers()) {
                System.out.println("ID: " + teacher.getID() + ", Name: " + teacher.getName() +
                        ", Salary: " + teacher.getSalary());
            }
        }
    }
}
