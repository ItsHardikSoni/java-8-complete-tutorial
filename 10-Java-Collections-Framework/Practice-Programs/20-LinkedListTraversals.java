import java.util.LinkedList;
import java.util.ListIterator;

class LinkedListTraversals {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Aarav");
        names.add("Diya");
        names.add("Kabir");

        System.out.print("Iterator: ");
        java.util.Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        System.out.print("Reverse ListIterator: ");
        ListIterator<String> listIterator = names.listIterator(names.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
    }
}
