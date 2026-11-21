import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class GroupingByFirstCharacter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aarav", "Diya", "Amit", "Kabir", "Anita");
        Map<Character, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(name -> Character.toUpperCase(name.charAt(0))));
        System.out.println(grouped);
    }
}
