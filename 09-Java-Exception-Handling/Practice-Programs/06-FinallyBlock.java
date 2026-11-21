class FinallyBlock {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (java.lang.ArithmeticException exception) {
            System.out.println("Exception handled.");
        } finally {
            System.out.println("Finally block always executes.");
        }
    }
}
