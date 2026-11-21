import java.util.HashMap;
import java.util.Scanner;

class HashMapRetrieveByKey {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        students.put(101, "Aarav");
        students.put(102, "Diya");
        students.put(103, "Kabir");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.println("Student: " + students.getOrDefault(id, "Not found"));
        scanner.close();
    }
}
