import java.util.function.Function;

class FunctionChaining {
    public static void main(String[] args) {
        Function<String, String> trim = String::trim;
        Function<String, String> lower = String::toLowerCase;
        Function<String, String> surround =
                value -> "[" + value + "]";

        String result = trim.andThen(lower).andThen(surround).apply("  Java 8  ");
        System.out.println(result);
    }
}
