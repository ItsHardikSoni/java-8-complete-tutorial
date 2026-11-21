import java.util.ArrayList;

class ArrayListAddUpdateRemove {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Aarav");
        names.add("Diya");
        names.add("Kabir");

        names.set(1, "Meera");
        names.remove("Kabir");

        System.out.println(names);
    }
}
