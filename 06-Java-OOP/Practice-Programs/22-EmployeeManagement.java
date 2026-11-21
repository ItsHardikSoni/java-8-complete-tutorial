abstract class Staff {
    protected String name;
    protected double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    void display() {
        System.out.println(name + ": " + calculateSalary());
    }
}

class PermanentEmployee extends Staff {
    PermanentEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    double calculateSalary() {
        return baseSalary + baseSalary * 0.20;
    }
}

class ContractEmployee extends Staff {
    private int hours;

    ContractEmployee(String name, double hourlyRate, int hours) {
        super(name, hourlyRate);
        this.hours = hours;
    }

    double calculateSalary() {
        return baseSalary * hours;
    }
}

class EmployeeManagement {
    public static void main(String[] args) {
        Staff permanent = new PermanentEmployee("Priya", 40000);
        Staff contract = new ContractEmployee("Sohan", 500, 160);
        permanent.display();
        contract.display();
    }
}
