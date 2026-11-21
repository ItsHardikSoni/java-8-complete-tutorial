import java.util.ArrayList;
import java.util.Scanner;

class ArrayListContains {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Aarav");
        names.add("Diya");
        names.add("Kabir");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = scanner.nextLine();
        System.out.println(names.contains(name) ? "Element exists" : "Element does not exist");
        scanner.close();
    }
}
