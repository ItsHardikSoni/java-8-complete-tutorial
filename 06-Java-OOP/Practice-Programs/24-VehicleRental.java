abstract class RentalVehicle {
    private String registrationNumber;

    RentalVehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    String getRegistrationNumber() {
        return registrationNumber;
    }

    abstract double calculateRent(int days);
}

class CarRental extends RentalVehicle {
    CarRental(String registrationNumber) {
        super(registrationNumber);
    }

    double calculateRent(int days) {
        return days * 2000;
    }
}

class BikeRental extends RentalVehicle {
    BikeRental(String registrationNumber) {
        super(registrationNumber);
    }

    double calculateRent(int days) {
        return days * 500;
    }
}

class VehicleRental {
    public static void main(String[] args) {
        RentalVehicle car = new CarRental("GJ-01-AA-1234");
        RentalVehicle bike = new BikeRental("GJ-01-BB-5678");
        System.out.println(car.getRegistrationNumber() + ": " + car.calculateRent(3));
        System.out.println(bike.getRegistrationNumber() + ": " + bike.calculateRent(3));
    }
}
