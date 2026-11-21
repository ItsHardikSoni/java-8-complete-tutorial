import java.util.Arrays;
import java.util.List;

class ArrayListMethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aarav", "Diya", "Kabir");
        names.forEach(System.out::println);
    }
}
