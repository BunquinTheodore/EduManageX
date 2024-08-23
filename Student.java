public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int totalFees;

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.totalFees = 30000; // Assuming the total fees for a student is 30,000
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public void updateFeesPaid(int fees) {
        this.feesPaid += fees;
    }

    public int getRemainingFees() {
        return totalFees - feesPaid;
    }
}
