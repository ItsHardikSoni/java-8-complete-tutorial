class Employee {
    private String name;
    private int employeeId;
    private double monthlySalary;

    public Employee(String name, int employeeId, double monthlySalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Annual Salary: " + calculateAnnualSalary());
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Hardik", 101, 50000);
        employee.displayDetails();
    }
}
