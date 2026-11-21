import java.util.Arrays;
import java.util.List;

class SalaryEmployee {
    private final double salary;

    SalaryEmployee(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class AverageEmployeeSalary {
    public static void main(String[] args) {
        List<SalaryEmployee> employees = Arrays.asList(
                new SalaryEmployee(50000),
                new SalaryEmployee(75000),
                new SalaryEmployee(60000));
        double average = employees.stream()
                .mapToDouble(SalaryEmployee::getSalary)
                .average()
                .orElse(0);
        System.out.println("Average salary: " + average);
    }
}
