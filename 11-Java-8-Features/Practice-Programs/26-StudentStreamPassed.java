import java.util.Arrays;
import java.util.List;

class StreamStudent {
    private final String name;
    private final int marks;

    StreamStudent(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + ":" + marks;
    }
}

class StudentStreamPassed {
    public static void main(String[] args) {
        List<StreamStudent> students = Arrays.asList(
                new StreamStudent("Aarav", 35),
                new StreamStudent("Diya", 82),
                new StreamStudent("Kabir", 55));
        students.stream()
                .filter(student -> student.getMarks() >= 40)
                .forEach(System.out::println);
    }
}
