package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Student extends Person {
    private String id;
    private String password;
    private String name;
    private double walletBalance;
    private boolean isEnrolled;
    private String enrolledDepartment;
    private List<String> enrolledYearLevels;
    private double tuitionLiability;
    private double tuition;
    private double paidTuition;
    private double totalGrades;
    private double roundedAverageGrade;


    public Student(String id, String password, String name) {
        super(id, name);
        this.id = id;
        this.password = password;
        this.name = name;
        this.walletBalance = 0;
        this.isEnrolled = false;
        this.enrolledDepartment = null;
        this.enrolledYearLevels = new ArrayList<>();
        this.tuition = 30000;
        this.paidTuition = 0.0;
        this.totalGrades = 0;
        this.roundedAverageGrade = 0.0;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return walletBalance;
    }

    @Override
    public void showID() {
        System.out.println("\n====================================================");
        System.out.println("                  STUDENT IDENTIFICATION            ");
        System.out.println("====================================================");
        System.out.println("   Name   : " + name);
        System.out.println("   ID     : " +  id);
        System.out.println("====================================================\n");
    }

    public void calculateTuition(double yearlyTuition) {
        // Add the yearly tuition to the current liability
        tuitionLiability += yearlyTuition;
        if (tuitionLiability < 0) {
            tuitionLiability = 0; // Prevents negative liability
        }
        System.out.println("\n=================== TUITION CALCULATION ===================");
        System.out.println("Updated Tuition Liability: " +  tuitionLiability);
        System.out.println("==========================================================\n");
    }
    
    public void enroll(Scanner scanner) {
        // Check if student is already enrolled in a department
        if (isEnrolled && enrolledDepartment != null) {
            System.out.println("You are already enrolled in " + enrolledDepartment);
            enrollInAdditionalYear(scanner);  // Call for enrolling in an additional year
            return;
        }
    
        System.out.println("====================================================");
        System.out.println("               DEPARTMENT SELECTION            ");
        System.out.println("====================================================");
        while (true) {
            try {
                System.out.println("Choose Department");
                System.out.println("1. College of Engineering");
                System.out.println("2. College of Fine Arts and Architecture");
                System.out.println("3. College of Informatics and Computing Sciences");
                System.out.println("4. College of Information Technology");
                System.out.print("Enter choice: ");
                
                int deptChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                // Assign department based on choice, throw an exception for invalid choices
                enrolledDepartment = switch (deptChoice) {
                    case 1 -> "College of Engineering";
                    case 2 -> "College of Fine Arts and Architecture";
                    case 3 -> "College of Informatics and Computing Sciences";
                    case 4 -> "College of Information Technology";
                    default -> throw new IllegalArgumentException("Invalid choice. Please select a valid department number.\n");
                    
                };
                break; // Exit loop if valid choice is made
            } catch (InputMismatchException e) {
                System.out.println("  Invalid input. Please enter a number corresponding to the department.");
                System.out.println("-------------------------------------------------------");
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("  " + e.getMessage());
            }
        }

        double yearlyTuition = enrollInYear(scanner, enrolledDepartment);
        this.isEnrolled = true;
        calculateTuition(yearlyTuition); // Pass the yearlyTuition here
    }

    private void enrollInAdditionalYear(Scanner scanner) {
        System.out.print("  Would you like to enroll in another year level? (Y/N): ");
        String response = scanner.nextLine().trim().toUpperCase();
        if (response.equals("Y")) {
            double yearlyTuition = enrollInYear(scanner, enrolledDepartment);
            calculateTuition(yearlyTuition); // Add the new year's tuition to the existing liability
        }
    }

    private double enrollInYear(Scanner scanner, String department) {
        String yearLevel;
        double yearlyTuition = 30000.0; // Fixed tuition for all year levels
        
        System.out.println("====================================================");
        System.out.println("              YEAR LEVEL SELECTION            ");
        System.out.println("====================================================");

        while (true) {
            try {
                System.out.println("Choose Year Level");
                System.out.println("1. 1st Year (Freshman)");
                System.out.println("2. 2nd Year (Sophomore)");
                System.out.println("3. 3rd Year (Junior)");
                System.out.println("4. 4th Year (Senior)");
                System.out.print("Enter choice: ");
                int yearChoice = scanner.nextInt();
                scanner.nextLine();
    
                yearLevel = switch (yearChoice) {
                    case 1 -> "First Year";
                    case 2 -> "Second Year";
                    case 3 -> "Third Year";
                    case 4 -> "Fourth Year";
                    default -> throw new IllegalArgumentException("Invalid choice. Please select a valid year level.\n");
                };
    
                if (!enrolledYearLevels.contains(yearLevel)) {
                    enrolledYearLevels.add(yearLevel);
                    displaySubjects(department, yearLevel);
                } else {
                    System.out.println("  You are already enrolled in this year level.");
                }
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("  Invalid input. Please enter a number corresponding to the year level.");
                System.out.println("-------------------------------------------------------");
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("  " + e.getMessage());
            }
        }
    
        return yearlyTuition; // Return the fixed tuition for the selected year level
    }
    

    public void displaySubjects(String department, String yearLevel) {
        List<String> subjects = CollegeDepartmentData.getCurriculum(department, yearLevel);
        
        System.out.println("\n====================================================");
        System.out.printf("    Subjects for in " + yearLevel, department);
        System.out.println("====================================================");

        if (subjects != null) {
            System.out.println("________________________________________________________________________________________________");
            System.out.println("Enrolled Subjects for " + yearLevel + " in " + department + ":");
            for (String subject : subjects) {
                System.out.println("    - " + subject);
            }
            System.out.println("\nTuition for this Year Level: " + tuition);
        } else {
            System.out.println("No subjects found for this department and year level.");
        }
        System.out.println("====================================================\n");
    }

    public void topUp(double amount) {
        if (amount > 0) {
            walletBalance += amount;
            System.out.println("Top-up successful! Added $" + amount + " to your wallet.");
            System.out.println("====================================================\n");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public double getTotalPaidTuition() {
        return paidTuition; // Returns the amount the student has paid so far
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            walletBalance += amount;
            System.out.println("Added $" + amount + " to wallet. Current balance: $" + walletBalance);
        } else {
            System.out.println("Invalid amount to add.");
        }
    }

    public void payTuition(Scanner scanner) {
        System.out.println("====================================================");
        System.out.println("                     PAY TUITION                    ");
        System.out.println("====================================================");

        if (!isEnrolled) {
            System.out.println("You must be enrolled to pay tuition.");
            return;
        }
    
        System.out.print("Enter amount to pay towards tuition: ");
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); 
    
            if (amount > 0 && amount <= walletBalance) {
                walletBalance -= amount;
                tuitionLiability -= amount;
                paidTuition += amount; 
    
                if (tuitionLiability <= 0) {
                    tuitionLiability = 0;
                    System.out.println("Tuition fully paid. You have no remaining liability.");
                } else {
                    System.out.println("Payment successful. Remaining Tuition Liability: $" + tuitionLiability);
                }
                System.out.println("Updated Wallet Balance: $" + walletBalance);
            } else {
                System.out.println("Invalid amount. Please ensure you have enough funds in your wallet.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine();
        }
        System.out.println("====================================================\n");
    }
    
    public void showLiabilities() {
        System.out.println("====================================================");
        System.out.println("                  TUITION LIABILITY                 ");
        System.out.println("====================================================");

        if (!isEnrolled) {
            System.out.println("You have no liability, you are not enrolled.");
            return;
        }

        double remainingBalance = tuitionLiability;
        System.out.println("Tuition Liability: $" + tuitionLiability);
        System.out.println("Wallet Balance: $" + walletBalance);
        System.out.println("Remaining Balance to Pay: $" + (remainingBalance > 0 ? remainingBalance : 0));

        if (remainingBalance <= 0) {
            System.out.println("You have no liability.");
        }
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void viewWallet() {
        System.out.println("====================================================");
        System.out.println("                  WALLET BALANCE                    ");
        System.out.println("====================================================");
        System.out.println("Current Wallet Balance: " +  walletBalance);
        System.out.println("====================================================\n");
    }
    
    public double getTotalTuition() {
        return tuitionLiability; // Since we already calculate this in calculateTuition()
    }

    public void showGrade() {
        System.out.println("\n====================================================");
        System.out.println("                  STUDENT GRADES                  ");
        System.out.println("====================================================");
        
        if (!isEnrolled) {
            System.out.println("Grade: 5 (Not enrolled)");
            return;
        }
        
        if (tuitionLiability > 0) {
            System.out.println("Grade: 4 (Pending liabilities)");
            return;
        }
    
        int subjectCount = 0;
        Random random = new Random();
        double[] possibleGrades = {1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0};
    
        // Loop through each enrolled year level to retrieve and grade subjects
        for (String yearLevel : enrolledYearLevels) {
            List<String> subjects = CollegeDepartmentData.getCurriculum(enrolledDepartment, yearLevel);
            
            if (subjects == null || subjects.isEmpty()) {
                System.out.println("No subjects found for " + yearLevel + " in " + enrolledDepartment);
                continue;
            }

            for (String subject : subjects) {
                double grade = possibleGrades[random.nextInt(possibleGrades.length)];
                System.out.println(subject + ": " + grade);
                totalGrades += grade;
                subjectCount++;
            }
            System.out.println("________________________________________________________________________________________________");
        }
    
        if (subjectCount > 0) {
            double averageGrade = totalGrades / subjectCount;
            roundedAverageGrade = calculateAverageGrade(averageGrade);
            System.out.printf("\nAverage Grade: %.2f (Rounded: %.2f)\n", averageGrade, roundedAverageGrade);
        } else {
            System.out.println("No subjects found to calculate an average grade.");
        }
    }

    public double calculateAverageGrade(double averageGrade) {
        double[] validGrades = {1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0};
    
        double closestGrade = validGrades[0];
        double smallestDifference = Math.abs(averageGrade - closestGrade);
    
        for (double validGrade : validGrades) {
            double difference = Math.abs(averageGrade - validGrade);
            if (difference < smallestDifference) {
                closestGrade = validGrade;
                smallestDifference = difference;
            }
        }
        return closestGrade;
    }
    

    public void applyScholarship() {
        if (!isEnrolled) {
            System.out.println("Cannot apply for a scholarship if not enrolled.");
        }
        else {
            System.out.printf("Rounded Average Grade: %.2f%n", roundedAverageGrade);
            
            if (roundedAverageGrade >= 1.0 && roundedAverageGrade <= 1.50) {
                double scholarshipAmount = 10000;
                walletBalance += scholarshipAmount;
                System.out.println("Congratulations! You received a scholarship of PHP " + scholarshipAmount + ".");
                System.out.println("Your updated wallet balance is: PHP " + walletBalance);
            } else {
                System.out.println("No scholarship applicable based on your grades.");
            }
        }
    }
}
