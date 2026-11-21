import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ManagementStudent {
    private final String name;
    private final int marks;

    ManagementStudent(String name, int marks) {
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

class StudentManagementSystem {
    public static void main(String[] args) {
        List<ManagementStudent> students = new ArrayList<>(
                Arrays.asList(
                        new ManagementStudent("Aarav", 72),
                        new ManagementStudent("Diya", 91),
                        new ManagementStudent("Kabir", 38)));

        System.out.println("Passed:");
        students.stream()
                .filter(student -> student.getMarks() >= 40)
                .forEach(System.out::println);

        Optional<ManagementStudent> highest = students.stream()
                .reduce((first, second) ->
                        first.getMarks() >= second.getMarks() ? first : second);
        System.out.println("Highest: " + highest.orElse(null));
    }
}
