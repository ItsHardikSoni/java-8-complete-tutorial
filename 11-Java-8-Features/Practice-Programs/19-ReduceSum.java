import java.util.Arrays;

class ReduceSum {
    public static void main(String[] args) {
        int sum = Arrays.asList(10, 20, 30, 40).stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}
