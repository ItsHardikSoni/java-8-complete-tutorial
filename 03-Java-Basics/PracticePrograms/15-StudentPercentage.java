import java.util.Scanner;

public class StudentPercentage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks in Java: ");
        double java = sc.nextDouble();

        System.out.print("Enter marks in DBMS: ");
        double dbms = sc.nextDouble();

        System.out.print("Enter marks in DSA: ");
        double dsa = sc.nextDouble();

        double total = java + dbms + dsa;

        double percentage = (total / 300) * 100;

        String grade;

        if (java < 35 || dbms < 35 || dsa < 35) {
            grade = "Fail";
        } else if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else {
            grade = "D";
        }

        System.out.println("\n----- Student Result -----");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}