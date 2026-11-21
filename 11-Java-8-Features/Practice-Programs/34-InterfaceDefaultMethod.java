interface Greeting {
    String getMessage();

    default void greet() {
        System.out.println("Hello: " + getMessage());
    }
}

class InterfaceDefaultMethod implements Greeting {
    @Override
    public String getMessage() {
        return "Java 8";
    }

    public static void main(String[] args) {
        new InterfaceDefaultMethod().greet();
    }
}
