package concurrency.producerConsumerProblems.usingWaitAndNotify;

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
        producer.start();
        consumer.start();
    }
}
