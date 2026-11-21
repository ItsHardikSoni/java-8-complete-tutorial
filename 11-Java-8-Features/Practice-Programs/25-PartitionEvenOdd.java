import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PartitionEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
        Map<Boolean, List<Integer>> partition =
                numbers.stream().collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println("Even: " + partition.get(true));
        System.out.println("Odd: " + partition.get(false));
    }
}
