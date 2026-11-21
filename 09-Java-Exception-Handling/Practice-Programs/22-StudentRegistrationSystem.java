import java.util.Scanner;

class StudentRegistrationSystem {
    static class InvalidStudentException extends Exception {
        InvalidStudentException(String message) { super(message); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        try {
            if (name.trim().length() == 0) throw new InvalidStudentException("Name cannot be empty.");
            if (age < 5 || age > 100) throw new InvalidStudentException("Invalid student age.");
            System.out.println("Student registered: " + name);
        } catch (InvalidStudentException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
