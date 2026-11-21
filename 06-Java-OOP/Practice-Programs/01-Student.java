class Student {
    String name;
    int rollNumber;
    int age;

    Student(String name, int rollNumber, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Age: " + age);
    }

    public static void main(String[] args) {
        new Student("Hardik", 101, 20).display();
        new Student("Aarav", 102, 21).display();
    }
}
