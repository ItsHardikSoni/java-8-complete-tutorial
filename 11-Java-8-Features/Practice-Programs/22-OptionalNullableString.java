import java.util.Optional;

class OptionalNullableString {
    public static void main(String[] args) {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println(optional.orElse("Value is unavailable"));
    }
}
