import java.util.function.Supplier;

class SupplierWelcomeMessage {
    public static void main(String[] args) {
        Supplier<String> welcome = () -> "Welcome to Java 8 Programming!";
        System.out.println(welcome.get());
    }
}
