class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class AssociationPerson {
    Address address;

    AssociationPerson(Address address) {
        this.address = address;
    }
}

class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class AggregationDepartment {
    String departmentName;

    AggregationDepartment(String departmentName) {
        this.departmentName = departmentName;
    }
}

class AggregationTeam {
    AggregationDepartment department;

    AggregationTeam(AggregationDepartment department) {
        this.department = department;
    }
}

class CompositionCar {
    private Engine engine = new Engine();

    void start() {
        engine.start();
    }
}

class Relationships {
    public static void main(String[] args) {
        Address address = new Address("Ahmedabad");
        System.out.println("Association: " + new AssociationPerson(address).address.city);

        AggregationDepartment department = new AggregationDepartment("IT");
        System.out.println("Aggregation: " + new AggregationTeam(department).department.departmentName);

        CompositionCar car = new CompositionCar();
        car.start();
    }
}
