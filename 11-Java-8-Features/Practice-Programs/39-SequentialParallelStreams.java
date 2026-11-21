import java.util.stream.LongStream;

class SequentialParallelStreams {
    public static void main(String[] args) {
        long limit = 10_000_000L;

        long startSequential = System.nanoTime();
        long sequentialSum = LongStream.rangeClosed(1, limit).sum();
        long sequentialTime = System.nanoTime() - startSequential;

        long startParallel = System.nanoTime();
        long parallelSum = LongStream.rangeClosed(1, limit).parallel().sum();
        long parallelTime = System.nanoTime() - startParallel;

        System.out.println("Sequential sum: " + sequentialSum
                + ", time: " + sequentialTime + " ns");
        System.out.println("Parallel sum: " + parallelSum
                + ", time: " + parallelTime + " ns");
    }
}
