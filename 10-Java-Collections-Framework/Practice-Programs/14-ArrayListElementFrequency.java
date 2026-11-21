import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

class ArrayListElementFrequency {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Pen");
        items.add("Book");
        items.add("Pen");
        items.add("Pencil");
        items.add("Book");

        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (String item : items) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }
        System.out.println(frequency);
    }
}
