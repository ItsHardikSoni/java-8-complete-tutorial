import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StreamEmployee {
    private final String name;
    private final double salary;

    StreamEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ":" + salary;
    }
}

class SortEmployeesBySalary {
    public static void main(String[] args) {
        List<StreamEmployee> employees = Arrays.asList(
                new StreamEmployee("Aarav", 50000),
                new StreamEmployee("Diya", 75000),
                new StreamEmployee("Kabir", 60000));
        employees.stream()
                .sorted(Comparator.comparingDouble(StreamEmployee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
