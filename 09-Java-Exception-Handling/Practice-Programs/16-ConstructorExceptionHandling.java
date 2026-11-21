import java.util.Scanner;

class ConstructorExceptionHandling {
    static class Student {
        String name;
        Student(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        try {
            Student student = new Student(name);
            System.out.println("Student created: " + student.name);
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not create student: " + exception.getMessage());
        }
        scanner.close();
    }
}
