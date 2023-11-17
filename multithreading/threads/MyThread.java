package multithreading.threads;

/**
 * User defined Thread creation using Thread class
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            /**
             * If you want certain threads to execute sequentially in a specific order,
             * you can use join() to enforce this order.
             * In this example, the main thread starts three threads (t1, t2, and t3) and
             * then uses join() to wait for each of them to finish before
             * printing "All threads have finished."
             */
            myThread.join();

            /**
             * We cannot start dead or already started thread agian.
             * if we start again then will get "java.lang.IllegalThreadStateException"
             */
            // myThread.start();
        }
        System.out.println("All threads have finished.");
    }
}

/**
 * Thread creation using Runnable interface
 */
class MyRunnable implements Runnable {

    // @Override
    public void run() {
        System.out.println("User defined thread using runnable interface..!" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        new Thread(myRunnable).start();
        // Using lamda expression
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
