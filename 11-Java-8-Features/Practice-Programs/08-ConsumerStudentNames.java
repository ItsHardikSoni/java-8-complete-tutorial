import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsumerStudentNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aarav", "Diya", "Kabir");
        Consumer<String> printName = name -> System.out.println("Student: " + name);
        names.forEach(printName);
    }
}
