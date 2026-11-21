import java.util.Scanner;

class EmployeeManagementSystem {
    static class InvalidEmployeeException extends Exception {
        InvalidEmployeeException(String message) { super(message); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        try {
            if (name.trim().length() == 0) throw new InvalidEmployeeException("Employee name cannot be empty.");
            if (salary <= 0) throw new InvalidEmployeeException("Salary must be positive.");
            System.out.println("Employee: " + name + ", Salary: " + salary);
        } catch (InvalidEmployeeException exception) {
            System.out.println(exception.getMessage());
        }
        scanner.close();
    }
}
