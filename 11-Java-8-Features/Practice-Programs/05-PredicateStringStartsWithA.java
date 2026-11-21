import java.util.function.Predicate;

class PredicateStringStartsWithA {
    public static void main(String[] args) {
        Predicate<String> startsWithA =
                value -> value != null && value.toLowerCase().startsWith("a");
        System.out.println(startsWithA.test("Aarav"));
        System.out.println(startsWithA.test("Kabir"));
    }
}
