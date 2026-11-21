interface CalculatorInterface {
    static int add(int first, int second) {
        return first + second;
    }
}

class InterfaceStaticMethod {
    public static void main(String[] args) {
        System.out.println("Sum: " + CalculatorInterface.add(10, 25));
    }
}
