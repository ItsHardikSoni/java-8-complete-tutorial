import java.util.function.Function;

class FunctionSquare {
    public static void main(String[] args) {
        Function<Integer, Integer> square = number -> number * number;
        System.out.println(square.apply(9));
    }
}
