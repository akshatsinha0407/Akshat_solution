import java.util.*;
import java.util.concurrent.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            tasks.add(() -> {
                System.out.println("Task " + n + " running in " + Thread.currentThread().getName());
                return n * n;
            });
        }
        List<Future<Integer>> futures = executor.invokeAll(tasks);
        for (Future<Integer> f : futures) System.out.println("Result: " + f.get());
        executor.shutdown();
    }
}
