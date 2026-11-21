import java.util.Scanner;

class StudentResult {
    private String name;
    private int[] marks;

    public StudentResult(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculatePercentage() {
        return (double) calculateTotal() / marks.length;
    }

    public char calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return 'A';
        }
        if (percentage >= 75) {
            return 'B';
        }
        if (percentage >= 60) {
            return 'C';
        }
        if (percentage >= 40) {
            return 'D';
        }
        return 'F';
    }

    public void displayResult() {
        System.out.println("Name: " + name);
        System.out.println("Total: " + calculateTotal());
        System.out.printf("Percentage: %.2f%n", calculatePercentage());
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int[] marks = new int[5];
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        new StudentResult(name, marks).displayResult();
        scanner.close();
    }
}
