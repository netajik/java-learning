package concurrency.producerConsumerProblems.usingBlockingQueue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

class Consumer extends Thread {

    private BlockingQueue<Integer> sharedQueue;

    Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while(true){
            try {
                /**
                 * take method retrieves and removes the head of this queue,
                 * waiting if necessary until an element becomes available.
                 */
                System.out.println("Consumed data: "+sharedQueue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
