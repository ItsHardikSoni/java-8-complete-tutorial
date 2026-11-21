import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<String> employeeNames = new ArrayList<>();
        employeeNames.add("Aarav");
        employeeNames.add("Diya");

        Map<Integer, String> employeeById = new HashMap<>();
        employeeById.put(101, "Aarav");
        employeeById.put(102, "Diya");

        employeeById.put(103, "Kabir");
        employeeNames.add("Kabir");

        System.out.println("Employees: " + employeeNames);
        System.out.println("Employee IDs: " + employeeById);
        System.out.println("Employee 102: " + employeeById.get(102));
    }
}
