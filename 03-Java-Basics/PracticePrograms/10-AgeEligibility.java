import java.util.Scanner;

public class StudentVoteEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the student's age
        System.out.print("Enter the student's age: ");
        int age = scanner.nextInt();

        // Check eligibility (minimum voting age is 18)
        if (age < 0) {
            System.out.println("Invalid age entered. Age cannot be negative.");
        } else if (age >= 18) {
            System.out.println("The student is eligible to vote.");
        } else {
            System.out.println("The student is not eligible to vote.");
        }

        scanner.close();
    }
}
