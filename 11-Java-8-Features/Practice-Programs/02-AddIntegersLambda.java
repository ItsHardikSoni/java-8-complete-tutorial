import java.util.function.BiFunction;

class AddIntegersLambda {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(10, 20));
    }
}
