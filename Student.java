import java.util.Scanner;

class StudentDetails {

    // Data members
    private String studentName;
    private long rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public StudentDetails(String studentName, long rollNumber, double marks,
                          String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    public double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    public boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship
    public double calculateScholarship() {
        double baseFee = calculateFee();

        if (marks >= 85) {
            return 0.20 * baseFee;
        } 
        else if (marks >= 70) {
            return 0.10 * baseFee;
        } 
        else {
            return 0.0;
        }
    }

    // Calculate final fee
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Display student details
    public void displayDetails() {

        System.out.println();
        System.out.println("=============================================");
        System.out.println("        STUDENT REGISTRATION DETAILS");
        System.out.println("=============================================");

        System.out.println("Student Name:      " + studentName);
        System.out.println("Roll Number:       " + rollNumber);
        System.out.println("Marks Obtained:    " + marks);
        System.out.println("Course Registered: " + courseName);
        System.out.println("Course Credits:    " + courseCredits);

        if (checkEligibility()) {
            System.out.println("Eligibility:       Eligible");
        } 
        else {
            System.out.println("Eligibility:       Not Eligible");
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total Course Fee:  Rs. " + calculateFee());
        System.out.println("Scholarship:       Rs. " + calculateScholarship());
        System.out.println("Final Fee Payable: Rs. " + calculateFinalFee());
        System.out.println("=============================================");
    }
}


// Public class name must match Student.java
public class Student {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get student details
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        long rollNumber = scanner.nextLong();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        // Create StudentDetails object
        StudentDetails student = new StudentDetails(
            studentName,
            rollNumber,
            marks,
            courseName,
            courseCredits
        );

        // Check eligibility
        if (student.checkEligibility()) {
            student.displayDetails();
        } 
        else {
            System.out.println();
            System.out.println("Registration Denied!");
            System.out.println("Student does not meet the minimum eligibility criteria.");
            System.out.println("Minimum required marks: 50");
        }

        scanner.close();
    }
}