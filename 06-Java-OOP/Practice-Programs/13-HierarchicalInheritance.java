class Vehicle {
    void start() {
        System.out.println("Vehicle starts.");
    }
}

class HierarchicalCar extends Vehicle {
    void drive() {
        System.out.println("Car is driving.");
    }
}

class HierarchicalBike extends Vehicle {
    void ride() {
        System.out.println("Bike is riding.");
    }
}

class HierarchicalInheritance {
    public static void main(String[] args) {
        new HierarchicalCar().drive();
        new HierarchicalBike().ride();
    }
}
