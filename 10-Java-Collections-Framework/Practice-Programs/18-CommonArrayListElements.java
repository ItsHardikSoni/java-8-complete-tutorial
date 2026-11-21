import java.util.ArrayList;
import java.util.LinkedHashSet;

class CommonArrayListElements {
    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(10);
        first.add(20);
        first.add(30);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(20);
        second.add(30);
        second.add(40);

        LinkedHashSet<Integer> common = new LinkedHashSet<>(first);
        common.retainAll(second);
        System.out.println(common);
    }
}
