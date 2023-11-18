package multithreading.concurrencyproblems.producerconsumer.usingblockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer consumer problem using BlockingQueue
 */
public class ProducerConsumerTest2 {

    public static void main(String[] args) {
        /**
         * A Queue that additionally supports operations that wait for the queue
         * to become non-empty when retrieving an element, and wait for space to
         * become available in the queue when storing an element.
         */
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(5);
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}


