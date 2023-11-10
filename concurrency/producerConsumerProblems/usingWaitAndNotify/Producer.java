package concurrency.producerConsumerProblems.usingWaitAndNotify;

import java.util.Queue;
import java.util.Random;

class Producer extends Thread{

    private Queue<Integer> sharedQueue;
    private final int MAX_SIZE = 5;

    Producer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while(true){
            synchronized (sharedQueue) {
                while(sharedQueue.size()==5){
                    try{
                        System.out.println("Producer is waiting for consumer to consume");
                        sharedQueue.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                int data = new Random().nextInt(this.MAX_SIZE);
                sharedQueue.add(data);
                sharedQueue.notify();
            }
        }
    }
}
