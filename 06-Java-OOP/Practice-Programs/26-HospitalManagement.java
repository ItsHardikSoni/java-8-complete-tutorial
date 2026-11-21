abstract class PersonHospital {
    private String name;
    private int age;

    PersonHospital(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

class Doctor extends PersonHospital {
    private String specialization;

    Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Dr. " + getName() + ", " + specialization);
    }
}

class Patient extends PersonHospital {
    private String diagnosis;

    Patient(String name, int age, String diagnosis) {
        super(name, age);
        this.diagnosis = diagnosis;
    }

    void display() {
        System.out.println(getName() + ", Age " + getAge() + ", Diagnosis: " + diagnosis);
    }
}

class HospitalManagement {
    public static void main(String[] args) {
        new Doctor("Mehta", 40, "Cardiology").display();
        new Patient("Sharma", 35, "Fever").display();
    }
}
