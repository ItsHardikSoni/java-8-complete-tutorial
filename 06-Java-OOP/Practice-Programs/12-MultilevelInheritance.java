class PersonBase {
    String name;

    PersonBase(String name) {
        this.name = name;
    }
}

class EmployeeBase extends PersonBase {
    int employeeId;

    EmployeeBase(String name, int employeeId) {
        super(name);
        this.employeeId = employeeId;
    }
}

class Manager extends EmployeeBase {
    String department;

    Manager(String name, int employeeId, String department) {
        super(name, employeeId);
        this.department = department;
    }

    void display() {
        System.out.println(name + " " + employeeId + " " + department);
    }
}

class MultilevelInheritance {
    public static void main(String[] args) {
        new Manager("Kabir", 12, "IT").display();
    }
}
