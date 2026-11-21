import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class DepartmentEmployee {
    private final String name;
    private final String department;

    DepartmentEmployee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        List<DepartmentEmployee> employees = Arrays.asList(
                new DepartmentEmployee("Aarav", "IT"),
                new DepartmentEmployee("Diya", "HR"),
                new DepartmentEmployee("Kabir", "IT"));
        Map<String, List<DepartmentEmployee>> departments = employees.stream()
                .collect(Collectors.groupingBy(DepartmentEmployee::getDepartment));
        System.out.println(departments);
    }
}
