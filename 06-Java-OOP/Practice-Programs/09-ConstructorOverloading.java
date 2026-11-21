class ConstructorOverloading {
    String name;
    int age;

    ConstructorOverloading() {
        this("Unknown", 0);
    }

    ConstructorOverloading(String name) {
        this(name, 0);
    }

    ConstructorOverloading(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        ConstructorOverloading a = new ConstructorOverloading();
        ConstructorOverloading b = new ConstructorOverloading("Amit");
        ConstructorOverloading c = new ConstructorOverloading("Amit", 25);
        System.out.println(a.name + " " + b.name + " " + c.name + " " + c.age);
    }
}
