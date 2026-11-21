import java.util.LinkedHashSet;

class LinkedHashSetInsertionOrder {
    public static void main(String[] args) {
        LinkedHashSet<String> names = new LinkedHashSet<>();
        names.add("Kabir");
        names.add("Aarav");
        names.add("Meera");
        names.add("Diya");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
