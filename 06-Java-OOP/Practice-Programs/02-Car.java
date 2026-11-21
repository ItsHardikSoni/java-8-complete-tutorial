class Car {
    String brand;
    String model;
    String color;

    Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    void start() {
        System.out.println(brand + " " + model + " started.");
    }

    void stop() {
        System.out.println(brand + " " + model + " stopped.");
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", "Blue");
        car.start();
        car.stop();
    }
}
