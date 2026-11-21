import java.util.ArrayList;

class ArrayListStudentNames {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Aarav");
        names.add("Diya");
        names.add("Kabir");
        names.add("Meera");
        names.add("Riya");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
