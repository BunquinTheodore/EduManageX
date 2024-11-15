import java.util.InputMismatchException;
import java.util.Scanner;

import model.School;
import util.MenuUtils;

public class Main {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        // Display banner and program information once at startup
        System.out.println("               ==============================================================================");
        System.out.println("                                              E D U  M A N A G E   X");
        System.out.println("               ==============================================================================");
        System.out.println("                   _____ ____  _   _   __  __    _    _   _    _    ____ _____  __  __");
        System.out.println("                  | ____|  _ \\| | | | |  \\/  |  / \\  | \\ | |  / \\  / ___| ____| \\ \\/ /");
        System.out.println("                  |  _| | | | | | | | | |\\/| | / _ \\ |  \\| | / _ \\| |  _|  _|    \\  / ");
        System.out.println("                  | |___| |_| | |_| | | |  | |/ ___ \\| |\\  |/ ___ \\ |_| | |___   /  \\ ");
        System.out.println("                  |_____|____/ \\___/  |_|  |_/_/   \\_\\_| \\_/_/   \\_\\____|_____| /_/\\_\\");
        System.out.println("               ==============================================================================");
        System.out.println("                           CREATED BY : THEODORE VON JOSHUA M. BUNQUIN");
        System.out.println("               ==============================================================================\n\n\n");

        while (true) {
            displayMainMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        MenuUtils.clearScreen();
                        MenuUtils.registerMenu(scanner, school);
                        break;
                    case 2:
                        MenuUtils.clearScreen();
                        MenuUtils.loginAccount(scanner, school);
                        break;
                    case 3:
                        MenuUtils.clearScreen();
                        school.displaySchoolSummary();
                        break;
                    case 4:
                        System.out.println("Exiting the system.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n\n=======================================================");
        System.out.println("               SCHOOL MANAGEMENT SYSTEM");
        System.out.println("=======================================================");
        System.out.println(" 1. Register");
        System.out.println(" 2. Login");
        System.out.println(" 3. School Summary");
        System.out.println(" 4. Exit");
        System.out.println("-------------------------------------------------------");
        System.out.print(" Enter your choice: ");
    }
}
    