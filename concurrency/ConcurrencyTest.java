public class ConcurrencyTest extends Thread {
    // public ConcurrencyTest(String name) {
    // super(name);
    // }

    public static void main(String[] args) {
        System.out.println("Hello world");
        ConcurrencyTest thread = new ConcurrencyTest();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("run method1");
    }
}