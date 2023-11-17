package multithreading.concurrencyproblems.producerconsumer.usingBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {

    private BlockingQueue<Integer> sharedQueue;
    private final int MAX_SIZE = 5;

    Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while(true){
            int data = new Random().nextInt(this.MAX_SIZE);
            try {
                /**
                 * put method inserts the specified element into this queue,
                 * waiting if necessary for space to become available.
                 */
                System.out.println("Produced: "+data);
                sharedQueue.put(data);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
