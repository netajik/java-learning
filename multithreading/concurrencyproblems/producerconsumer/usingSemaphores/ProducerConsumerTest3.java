package multithreading.concurrencyproblems.producerconsumer.usingsemaphores;

public class ProducerConsumerTest3 {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}

/**
 * Note: https://www.scaler.com/topics/producer-consumer-problem-in-java/
 */