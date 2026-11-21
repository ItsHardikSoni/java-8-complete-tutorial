import java.util.stream.IntStream;

class SkipFirstThree {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).skip(3).forEach(System.out::println);
    }
}
