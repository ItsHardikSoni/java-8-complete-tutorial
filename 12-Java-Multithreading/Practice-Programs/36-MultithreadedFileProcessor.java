import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MultithreadedFileProcessor {
    public static void main(String[] args) throws Exception {
        Path directory = Files.createTempDirectory("java-file-processing");
        List<Path> files = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Path file = directory.resolve("file-" + i + ".txt");
            Files.write(file, ("Line 1" + i + "\nLine 2").getBytes());
            files.add(file);
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        for (Path file : files) {
            futures.add(executor.submit(() ->
                    Files.readAllLines(file).size()));
        }
        for (Future<Integer> future : futures) {
            System.out.println("Lines: " + future.get());
        }
        executor.shutdown();
    }
}
