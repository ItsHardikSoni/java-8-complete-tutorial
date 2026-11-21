
import java.util.Scanner;

class StudentGrading {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student marks (0-100): ");
        int marks = scanner.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks.");
        } else {
            char grade;
            if (marks >= 90) {
                grade = 'A';
            } else if (marks >= 80) {
                grade = 'B';
            } else if (marks >= 70) {
                grade = 'C';
            } else if (marks >= 60) {
                grade = 'D';
            } else if (marks >= 40) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            String result = marks >= 40 ? "Pass" : "Fail";
            System.out.println("Grade: " + grade);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
