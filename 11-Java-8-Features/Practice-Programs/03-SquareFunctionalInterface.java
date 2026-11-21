@FunctionalInterface
interface SquareOperation {
    int calculate(int number);
}

class SquareFunctionalInterface {
    public static void main(String[] args) {
        SquareOperation square = number -> number * number;
        System.out.println("Square: " + square.calculate(7));
    }
}
