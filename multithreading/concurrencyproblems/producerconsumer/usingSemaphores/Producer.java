package multithreading.concurrencyproblems.producerconsumer.usingsemaphores;

import java.util.Random;

public class Producer extends Thread{
    Queue queue;
    Producer(Queue queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while(true) {
            this.queue.put();
        }
    }
}
