import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.marks, this.marks);
    }

    @Override
    public String toString() {
        return name + ":" + marks;
    }
}

class ComparableStudentSort {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Aarav", 72));
        students.add(new Student("Diya", 91));
        students.add(new Student("Kabir", 84));
        Collections.sort(students);
        System.out.println(students);
    }
}
