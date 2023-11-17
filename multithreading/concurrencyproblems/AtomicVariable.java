package multithreading.concurrencyproblems;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * In multithreading, the shared entity mostly leads to a problem when
 * concurrency is incorporated.A shared entity such as, mutable object
 * or variable, might be changed, which may result in the inconsistency
 * of the program or database. So, it becomes crucial to deal with the
 * shared entity while accessed concurrently. An atomic variable can be
 * one of the alternatives in such a scenario.
 * Atomics ensure that operation on variables are performed atomically.
 * https://www.geeksforgeeks.org/atomic-variables-in-java-with-examples/
 */

// unsafe example
class Counter extends Thread {

    // Counter Variable
    int count = 0;

    // method which would be called upon
    // the start of execution of a thread
    public void run() {
        int max = 1_000_00_000;

        // incrementing counter
        // total of max times
        for (int i = 0; i < max; i++) {
            count++;
        }
    }
}

class UnSafeCounter {
    public static void main(String[] args)
            throws InterruptedException {
        // Instance of Counter Class
        Counter c = new Counter();

        // Defining Two different threads
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        // Threads start executing
        first.start();
        second.start();

        // main thread will wait for
        // both threads to get completed
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(c.count);
    }
}

// solution using syncronized block
class SynchronizedCounter extends Thread {

    // Counter Variable
    int count = 0;

    // method which would be called upon
    // the start of execution of a thread
    public synchronized void run() {

        int max = 1_000_00_000;

        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count++;
        }
    }
}

class SynchronizedExample {
    public static void main(String[] args)
            throws InterruptedException {
        // Instance of Counter Class
        SynchronizedCounter c = new SynchronizedCounter();

        // Defining Two different threads
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        // Threads start executing
        first.start();
        second.start();

        // main thread will wait for both
        // threads to complete execution
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(c.count);
    }
}

public class AtomicVariable extends Thread {

    // Atomic counter Variable
    AtomicInteger count;

    AtomicVariable() {
        count = new AtomicInteger();
    }

    public void run() {
        int max = 1_000_00_000;

        for (int i = 0; i < max; i++) {
            count.addAndGet(1);
        }
    }
}

class AtomicCounter {
    public static void main(String[] args)
            throws InterruptedException {
        // Instance of Counter Class
        AtomicVariable c = new AtomicVariable();

        // Defining Two different threads
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        // Threads start executing
        first.start();
        second.start();

        // main thread will wait for both
        // threads to complete execution
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(c.count);
    }
}
