import java.util.Scanner;

class StudentMarksManagement {
    private static String[] names = new String[100];
    private static int[] marks = new int[100];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Marks Management");
            System.out.println("1. Add student");
            System.out.println("2. Display students");
            System.out.println("3. Find highest mark");
            System.out.println("4. Find average mark");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                addStudent(scanner);
            } else if (choice == 2) {
                displayStudents();
            } else if (choice == 3) {
                displayHighest();
            } else if (choice == 4) {
                displayAverage();
            } else if (choice == 5) {
                System.out.println("Goodbye");
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        if (count == names.length) {
            System.out.println("Student list is full");
            return;
        }
        System.out.print("Enter student name: ");
        names[count] = scanner.nextLine();
        System.out.print("Enter marks: ");
        marks[count] = scanner.nextInt();
        scanner.nextLine();
        count++;
        System.out.println("Student added");
    }

    private static void displayStudents() {
        if (count == 0) {
            System.out.println("No students");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

    private static void displayHighest() {
        if (count == 0) {
            System.out.println("No students");
            return;
        }
        int highestIndex = 0;
        for (int i = 1; i < count; i++) {
            if (marks[i] > marks[highestIndex]) {
                highestIndex = i;
            }
        }
        System.out.println("Highest: " + names[highestIndex] + " - " + marks[highestIndex]);
    }

    private static void displayAverage() {
        if (count == 0) {
            System.out.println("No students");
            return;
        }
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += marks[i];
        }
        System.out.println("Average marks: " + (double) total / count);
    }
}
