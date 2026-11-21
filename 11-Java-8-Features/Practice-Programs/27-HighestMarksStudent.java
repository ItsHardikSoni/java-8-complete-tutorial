import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class MarksStudent {
    private final String name;
    private final int marks;

    MarksStudent(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + ":" + marks;
    }
}

class HighestMarksStudent {
    public static void main(String[] args) {
        List<MarksStudent> students = Arrays.asList(
                new MarksStudent("Aarav", 72),
                new MarksStudent("Diya", 91),
                new MarksStudent("Kabir", 84));
        Optional<MarksStudent> highest =
                students.stream().max(Comparator.comparingInt(MarksStudent::getMarks));
        System.out.println(highest.orElse(null));
    }
}
