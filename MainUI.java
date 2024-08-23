import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    private JFrame frame;
    private JPanel mainPanel, teacherPanel, studentPanel, summaryPanel;
    private School school;

    public MainUI() {
        // Initialize school object
        school = new School();

        // Create the main frame
        frame = new JFrame("School Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create main panel with card layout
        mainPanel = new JPanel(new CardLayout());

        // Initialize panels
        initializeMainMenu();
        initializeTeacherForm();
        initializeStudentForm();
        initializeSummaryView();

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void initializeMainMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));

        JButton teacherButton = new JButton("Teacher");
        teacherButton.addActionListener(e -> showPanel("teacherPanel"));
        JButton studentButton = new JButton("Student");
        studentButton.addActionListener(e -> showPanel("studentPanel"));
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(teacherButton);
        menuPanel.add(studentButton);
        menuPanel.add(exitButton);

        mainPanel.add(menuPanel, "menuPanel");
    }

    private void initializeTeacherForm() {
        teacherPanel = new JPanel();
        teacherPanel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("Enter your ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Enter your Name:");
        JTextField nameField = new JTextField();
        JLabel salaryLabel = new JLabel("Enter your Salary:");
        JTextField salaryField = new JTextField();
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    int salary = Integer.parseInt(salaryField.getText());

                    if (id <= 0 || salary < 0 || name.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid inputs.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Teacher teacher = new Teacher(id, name, salary);
                    school.addTeacher(teacher);
                    school.updateTotalMoneySpent(salary); // Update total money spent when a teacher is added

                    JOptionPane.showMessageDialog(frame, "Teacher added successfully!");
                    clearTeacherForm();
                    showPanel("menuPanel");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter numeric values for ID and Salary.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(e -> showPanel("menuPanel"));

        teacherPanel.add(idLabel);
        teacherPanel.add(idField);
        teacherPanel.add(nameLabel);
        teacherPanel.add(nameField);
        teacherPanel.add(salaryLabel);
        teacherPanel.add(salaryField);
        teacherPanel.add(submitButton);
        teacherPanel.add(backButton);

        mainPanel.add(teacherPanel, "teacherPanel");
    }

    private void initializeStudentForm() {
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(6, 2));

        JLabel idLabel = new JLabel("Enter your ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Enter your Name:");
        JTextField nameField = new JTextField();
        JLabel gradeLabel = new JLabel("Enter your Grade:");
        JTextField gradeField = new JTextField();
        JLabel feesLabel = new JLabel("Enter the Fees you want to pay:");
        JTextField feesField = new JTextField();
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    int grade = Integer.parseInt(gradeField.getText());
                    int feesPaid = Integer.parseInt(feesField.getText());

                    if (id <= 0 || grade <= 0 || feesPaid < 0 || name.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid inputs.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Student student = new Student(id, name, grade);
                    student.updateFeesPaid(feesPaid);
                    school.addStudent(student);
                    school.updateTotalMoneyEarned(feesPaid); // Update total money earned when fees are paid

                    JOptionPane.showMessageDialog(frame, "Student added successfully!");
                    clearStudentForm();
                    showPanel("menuPanel");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter numeric values for ID, Grade, and Fees.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(e -> showPanel("menuPanel"));

        studentPanel.add(idLabel);
        studentPanel.add(idField);
        studentPanel.add(nameLabel);
        studentPanel.add(nameField);
        studentPanel.add(gradeLabel);
        studentPanel.add(gradeField);
        studentPanel.add(feesLabel);
        studentPanel.add(feesField);
        studentPanel.add(submitButton);
        studentPanel.add(backButton);

        mainPanel.add(studentPanel, "studentPanel");
    }

    private void initializeSummaryView() {
        summaryPanel = new JPanel();
        summaryPanel.setLayout(new BorderLayout());

        JTextArea summaryTextArea = new JTextArea();
        summaryTextArea.setEditable(false);
        JButton backButton = new JButton("Back");

        backButton.addActionListener(e -> showPanel("menuPanel"));

        summaryPanel.add(new JScrollPane(summaryTextArea), BorderLayout.CENTER);
        summaryPanel.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(summaryPanel, "summaryPanel");

        // Action to display summary
        JMenuItem summaryMenuItem = new JMenuItem("View Summary");
        summaryMenuItem.addActionListener(e -> {
            StringBuilder summary = new StringBuilder();
            int totalMoneyEarned = school.getTotalMoneyEarned();
            int totalMoneySpent = school.getTotalMoneySpent();
            int moneyLeft = totalMoneyEarned - totalMoneySpent;

            summary.append("Total Money Earned: ").append(totalMoneyEarned).append("\n");
            summary.append("Total Money Spent: ").append(totalMoneySpent).append("\n");
            summary.append("Money Left: ").append(moneyLeft).append("\n\n"); // Added this line

            summary.append("Students:\n");
            for (Student student : school.getStudents()) {
                summary.append("ID: ").append(student.getID())
                        .append(", Name: ").append(student.getName())
                        .append(", Grade: ").append(student.getGrade())
                        .append(", Fees Paid: ").append(student.getFeesPaid()).append("\n");
            }

            summary.append("\nTeachers:\n");
            for (Teacher teacher : school.getTeachers()) {
                summary.append("ID: ").append(teacher.getID())
                        .append(", Name: ").append(teacher.getName())
                        .append(", Salary: ").append(teacher.getSalary()).append("\n");
            }

            summaryTextArea.setText(summary.toString());
            showPanel("summaryPanel");
        });

        // Add Summary to Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menu.add(summaryMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private void clearTeacherForm() {
        for (Component c : teacherPanel.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    private void clearStudentForm() {
        for (Component c : studentPanel.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    private void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
