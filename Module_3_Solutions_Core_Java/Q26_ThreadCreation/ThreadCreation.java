public class ThreadCreation {
    static class MyThread extends Thread {
        String msg;
        MyThread(String msg) { this.msg = msg; }
        public void run() {
            for (int i = 0; i < 5; i++) System.out.println(msg + " - " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread("Thread-1");
        Thread t2 = new MyThread("Thread-2");
        t1.start(); t2.start();
        t1.join(); t2.join();
    }
}
