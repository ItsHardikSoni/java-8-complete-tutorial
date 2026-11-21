class HelloJava8Lambda {
    public static void main(String[] args) {
        Runnable printMessage = () -> System.out.println("Hello Java 8");
        printMessage.run();
    }
}
