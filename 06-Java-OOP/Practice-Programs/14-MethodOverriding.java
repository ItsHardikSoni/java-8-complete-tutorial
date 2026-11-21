class Parent {
    void greet() {
        System.out.println("Hello from parent.");
    }
}

class Child extends Parent {
    @Override
    void greet() {
        System.out.println("Hello from child.");
    }
}

class MethodOverriding {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.greet();
    }
}
