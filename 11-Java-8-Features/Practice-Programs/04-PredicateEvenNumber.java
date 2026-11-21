import java.util.function.Predicate;

class PredicateEvenNumber {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("12 is even: " + isEven.test(12));
        System.out.println("15 is even: " + isEven.test(15));
    }
}
