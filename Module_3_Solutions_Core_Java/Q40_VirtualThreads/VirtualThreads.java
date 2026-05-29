public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        int count = 100_000;
        Thread[] threads = new Thread[count];
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // Simulated lightweight task
            });
        }
        for (Thread t : threads) t.join();
        System.out.println("100,000 virtual threads done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
