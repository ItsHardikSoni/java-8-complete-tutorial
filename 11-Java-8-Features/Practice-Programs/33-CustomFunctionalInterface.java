@FunctionalInterface
interface StringLengthCalculator {
    int calculateLength(String value);
}

class CustomFunctionalInterface {
    public static void main(String[] args) {
        StringLengthCalculator calculator = value -> value.length();
        System.out.println(calculator.calculateLength("Lambda"));
    }
}
