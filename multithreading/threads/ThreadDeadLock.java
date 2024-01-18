package multithreading.threads;

public class ThreadDeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1: holding lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }

                synchronized (lock2) {
                    System.out.println("Thread1: Holding lock1 and lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                // synchronized (lock1) { 
                // add comment to previous line and 
                // remove comments for this line to prevent deadloack
                // here we can prevent deadlock by changing the order of locks aqired by threads
                System.out.println("Thread2: holding lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }

                synchronized (lock1) {
                // synchronized (lock2) {
                // add comment to previous line and 
                // remove comments for this line to prevent deadloack
                    System.out.println("Thread2: Holding lock1 and lock2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

/*
 * Note 
 * In the given code, Thread 1 and Thread 2 are both attempting 
 * to acquire two locks in a different order. This sets up a scenario where a deadlock can occur:
 * 1. Thread 1 starts and acquires lock1.
 * 2. Thread 2 starts and acquires lock2.
 * Now, both threads are in a state where they are holding one lock and waiting for the other. 
 * Thread 1 is waiting for lock2, and Thread 2 is waiting for lock1. This forms a circular dependency, 
 * and neither thread can proceed because each holds a lock that the other needs.
 * The program may not terminate, and the threads could be stuck in a deadlock state indefinitely, 
 * waiting for each other to release the locks they need.
 * To prevent deadlocks, it's crucial to acquire locks in a consistent order across 
 * all threads in your application. If different threads acquire locks in a different order, 
 * you might end up with situations like this, where a circular dependency can occur, 
 * leading to a deadlock.
 * https://www.youtube.com/watch?v=srogmCxMRqM&list=PLzS3AYzXBoj8jq5o5qolE4Kki19j1UrS8&index=13
 * 
 */