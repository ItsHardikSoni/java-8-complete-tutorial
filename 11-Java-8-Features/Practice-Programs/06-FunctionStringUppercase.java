import java.util.function.Function;

class FunctionStringUppercase {
    public static void main(String[] args) {
        Function<String, String> toUpper = String::toUpperCase;
        System.out.println(toUpper.apply("java 8"));
    }
}
