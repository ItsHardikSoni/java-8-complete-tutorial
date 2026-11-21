import java.util.ArrayList;

class MergeArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(10);
        first.add(20);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(30);
        second.add(40);

        ArrayList<Integer> merged = new ArrayList<>(first);
        merged.addAll(second);
        System.out.println(merged);
    }
}
