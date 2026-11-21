class ExceptionPropagation {
    public static void main(String[] args) {
        try {
            firstMethod();
        } catch (java.lang.ArithmeticException exception) {
            System.out.println("Handled in main: " + exception.getMessage());
        }
    }
    static void firstMethod() {
        secondMethod();
    }
    static void secondMethod() {
        int result = 10 / 0;
        System.out.println(result);
    }
}
