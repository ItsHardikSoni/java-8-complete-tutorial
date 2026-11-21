import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class NamedStudent {
    private final String name;
    private final int marks;

    NamedStudent(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ":" + marks;
    }
}

class ComparatorStudentSort {
    public static void main(String[] args) {
        ArrayList<NamedStudent> students = new ArrayList<>();
        students.add(new NamedStudent("Kabir", 84));
        students.add(new NamedStudent("Aarav", 72));
        students.add(new NamedStudent("Diya", 91));

        Collections.sort(students,
                Comparator.comparing(NamedStudent::getName));
        System.out.println(students);
    }
}
