import java.util.stream.IntStream;

class SequentialParallelExecution {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int sequential = IntStream.rangeClosed(1, 100000)
                .map(i -> i * i)
                .sum();
        long sequentialTime = System.nanoTime() - start;

        start = System.nanoTime();
        int parallel = IntStream.rangeClosed(1, 100000)
                .parallel()
                .map(i -> i * i)
                .sum();
        long parallelTime = System.nanoTime() - start;

        System.out.println("Sequential: " + sequential
                + " in " + sequentialTime + " ns");
        System.out.println("Parallel: " + parallel
                + " in " + parallelTime + " ns");
    }
}
