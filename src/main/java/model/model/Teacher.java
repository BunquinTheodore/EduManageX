package model;

import java.util.List;
import java.util.Scanner;

public class Teacher extends Person{
    private String id;
    private String password;
    private String name;
    private String position;
    private double salary;
    private double wallet;
    private double balance;
    public String assignedDepartment;
    public String assignedYearLevel;

    public Teacher(String id, String password, String name) {
        super(id, name);
        this.id = id;
        this.password = password;
        this.name = name;
        this.position = null;
        this.salary = 0.0;
        this.wallet = salary;
        this.assignedDepartment = null;
        this.assignedYearLevel = null;
        this.balance = 0.0;
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

    public void setPosition(String position) {
        this.position = position;
        // Set salary based on position and initialize balance to match the salary
        this.salary = switch (position) {
            case "Teacher 1" -> 10000.0;
            case "Teacher 2" -> 20000.0;
            case "Teacher 3" -> 30000.0;
            case "Master Teacher" -> 40000.0;
            case "Dean" -> 50000.0;
            default -> 0.0;
        };
        this.balance = this.salary; // Initialize balance to the full salary amount
    }

    public void withdrawSalary(Scanner scanner) {
        System.out.println("\n===============================");
        System.out.println("       WITHDRAW SALARY        ");
        System.out.println("===============================");

        if (salary > 0) {
            System.out.print("  Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (amount > 0 && amount <= balance) {
                // Deduct from balance and add to wallet
                balance -= amount;
                wallet += amount;
                System.out.println(" Withdrew " + amount + ". Remaining balance: " + balance);
            } else if (amount > balance) {
                System.out.println("  Insufficient balance to withdraw this amount.");
            } else {
                System.out.println("  Invalid amount entered. Please enter a positive value.");
            }
        } else {
            System.out.println("  No salary available to withdraw.");
        }
    }

    public void viewWallet() {
        System.out.println("\n===============================");
        System.out.println("           WALLET              ");
        System.out.println("===============================");
        System.out.println(" Wallet Balance: $" + wallet);
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setAssignment(String department, String yearLevel) {
        this.assignedDepartment = department;
        this.assignedYearLevel = yearLevel;
    }

    @Override
    public void showID() {
        System.out.println("\n===============================");
        System.out.println("         TEACHER ID CARD       ");
        System.out.println("===============================");
        System.out.println(" Name: " + name);
        System.out.println(" ID: " + id);
        System.out.println(" Position: " + (position != null ? position : "Not set"));
        System.out.println("===============================");
    }
    
    public void enterPosition(Scanner scanner, Teacher teacher) {
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.println("\n===============================");
                System.out.println("         CHOOSE POSITION       ");
                System.out.println("===============================");
                System.out.println("1. Teacher 1");
                System.out.println("2. Teacher 2");
                System.out.println("3. Teacher 3");
                System.out.println("4. Master Teacher");
                System.out.println("5. Dean");
                System.out.print("Enter choice: ");
    
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    continue;
                }
    
                String position = switch (choice) {
                    case 1 -> "Teacher 1";
                    case 2 -> "Teacher 2";
                    case 3 -> "Teacher 3";
                    case 4 -> "Master Teacher";
                    case 5 -> "Dean";
                    default -> throw new IllegalArgumentException("Invalid choice");
                };
    
                teacher.setPosition(position);
                System.out.println("Position set to: " + position);
                validInput = true;
    
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void viewSalary(Teacher teacher) {
        if (teacher.getPosition() == null) {
            System.out.println("Please enter your position first.");
            return;
        }
        System.out.println("\n===============================");
        System.out.println("        SALARY DETAILS        ");
        System.out.println("===============================");
        System.out.println("Current Position: " + getPosition());
        System.out.println("Current Salary: $" + getSalary());
    }

    public void viewBalance(Teacher teacher) {
        if (teacher.getPosition() == null) {
            System.out.println("You have no balance!");
            return;
        }
        System.out.println("\n===============================");
        System.out.println("       REMAINING BALANCE       ");
        System.out.println("===============================");
        System.out.println("Remaining Balance: $" + balance);
    }

    public void assignDepartmentAndYear(Scanner scanner, Teacher teacher) {
        if (teacher.getPosition() == null) {
            System.out.println("Please enter your position first.");
            return;
        }
    
        String department;
        while (true) {
            try {
                System.out.println("\n===============================");
                System.out.println("        CHOOSE DEPARTMENT      ");
                System.out.println("===============================");
                System.out.println("1. College of Engineering");
                System.out.println("2. College of Fine Arts and Architecture");
                System.out.println("3. College of Informatics and Computing Sciences");
                System.out.println("4. College of Information Technology");
                System.out.print("Enter choice: ");
                
                int deptChoice = Integer.parseInt(scanner.nextLine().trim());
                
                if (deptChoice < 1 || deptChoice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    continue;
                }
    
                department = switch (deptChoice) {
                    case 1 -> "College of Engineering";
                    case 2 -> "College of Fine Arts and Architecture";
                    case 3 -> "College of Informatics and Computing Sciences";
                    case 4 -> "College of Information Technology";
                    default -> throw new IllegalArgumentException("Invalid choice");
                };
                break;
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        String yearLevel;
        while (true) {
            try {
                System.out.println("\n===============================");
                System.out.println("         CHOOSE YEAR LEVEL     ");
                System.out.println("===============================");
                System.out.println("1. 1st Year (Freshman)");
                System.out.println("2. 2nd Year (Sophomore)");
                System.out.println("3. 3rd Year (Junior)");
                System.out.println("4. 4th Year (Senior)");
                System.out.print("Enter choice: ");
                
                int yearChoice = Integer.parseInt(scanner.nextLine().trim());
                
                if (yearChoice < 1 || yearChoice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    continue;
                }
    
                yearLevel = switch (yearChoice) {
                    case 1 -> "First Year";
                    case 2 -> "Second Year";
                    case 3 -> "Third Year";
                    case 4 -> "Fourth Year";
                    default -> throw new IllegalArgumentException("Invalid choice");
                };
                break;
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    
        teacher.setAssignment(department, yearLevel);
        System.out.println("\n===============================");
        System.out.println("      ASSIGNED SUBJECTS        ");
        System.out.println("===============================");
        System.out.println("\nYou are assigned to these following subjects:");
        List<String> subjects = CollegeDepartmentData.getCurriculum(department, yearLevel);
        if (subjects != null) {
            for (String subject : subjects) {
                System.out.println("- " + subject);
            }
        }
        System.out.println("===============================");
    }

    public double getBaseSalary() {
        if (position == null) {
            // No position set, so return a base salary of $0.0
            return 0.0;
        }
    
        return switch (position) {
            case "Teacher 1" -> 10000.0;
            case "Teacher 2" -> 20000.0;
            case "Teacher 3" -> 30000.0;
            case "Master Teacher" -> 40000.0;
            case "Dean" -> 50000.0;
            default -> 0.0;
        };
    }
    
    
}
