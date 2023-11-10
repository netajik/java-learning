public class MultithreadingProblems {

    int count = 0;

    public static void main(String[] args) throws InterruptedException {
        MultithreadingProblems obj = new MultithreadingProblems();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.increment();
                ;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.decrement();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(obj.count);
    }

    synchronized void increment() {
        this.count++;
    }

    synchronized void decrement() {
        this.count--;
    }
}
