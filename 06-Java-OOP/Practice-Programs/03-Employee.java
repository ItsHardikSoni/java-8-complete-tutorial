class Employee {
    int employeeId;
    String name;
    double salary;

    Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(employeeId + " " + name + " - " + salary);
    }

    public static void main(String[] args) {
        new Employee(1001, "Neha", 55000).display();
    }
}
