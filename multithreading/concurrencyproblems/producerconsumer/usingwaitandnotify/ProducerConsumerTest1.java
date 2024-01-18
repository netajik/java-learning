package multithreading.concurrencyproblems.producerconsumer.usingwaitandnotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Producer consumer problem using wait and notify methods
 */
public class ProducerConsumerTest1 {

    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        consumer.start();
        producer.start();
    }
}


/**
 * Note:
 *  The issue in the given code lies in how the notify() method is used. 
 *  The notify() method wakes up one of the threads that are currently waiting on the object's monitor.
 *  However, in the producer-consumer problem, it's not guaranteed which thread will be woken up.
    The producer calls sharedQueue.notify() after producing an item.
    The consumer calls sharedQueue.notify() after consuming an item.
    Since notify() wakes up one of the waiting threads, there's a chance that 
    the wrong thread might be awakened, leading to unexpected behavior. 
    In particular, if the consumer is faster, it might consume an item before the producer has a chance to produce more.
    To address this issue, you can modify the code to use notifyAll() instead of notify(). 
    This will wake up all waiting threads, allowing the consumer to be awakened after the producer produces an item, and vice versa.
 */

 // https://www.scaler.com/topics/inter-thread-communication-in-java/