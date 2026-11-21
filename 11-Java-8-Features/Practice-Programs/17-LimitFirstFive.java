import java.util.stream.IntStream;

class LimitFirstFive {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 20).limit(5).forEach(System.out::println);
    }
}
