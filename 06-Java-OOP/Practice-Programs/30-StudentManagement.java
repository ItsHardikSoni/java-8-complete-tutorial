import java.util.ArrayList;
import java.util.List;

abstract class StudentRecord {
    private int rollNumber;
    private String name;

    StudentRecord(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    int getRollNumber() {
        return rollNumber;
    }

    String getName() {
        return name;
    }

    abstract String calculateGrade();

    void display() {
        System.out.println(rollNumber + " " + name + " - " + calculateGrade());
    }
}

class RegularStudent extends StudentRecord {
    private double marks;

    RegularStudent(int rollNumber, String name, double marks) {
        super(rollNumber, name);
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) {
            return "A";
        }
        if (marks >= 75) {
            return "B";
        }
        if (marks >= 60) {
            return "C";
        }
        if (marks >= 40) {
            return "D";
        }
        return "F";
    }
}

class StudentManagement {
    private List<StudentRecord> students = new ArrayList<>();

    void addStudent(StudentRecord student) {
        students.add(student);
    }

    void displayStudents() {
        for (StudentRecord student : students) {
            student.display();
        }
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.addStudent(new RegularStudent(101, "Aman", 92));
        management.addStudent(new RegularStudent(102, "Bina", 78));
        management.addStudent(new RegularStudent(103, "Chirag", 55));
        management.displayStudents();
    }
}
