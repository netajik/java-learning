package multithreading.concurrencyproblems.producerconsumer.usingwaitandnotify;

import java.util.Queue;

class Consumer extends Thread {

    private Queue<Integer> sharedQueue;

    Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while(true){
            synchronized (this.sharedQueue){
                while (sharedQueue.isEmpty()){
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumed data: "+sharedQueue.poll());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedQueue.notify();
            }
        }
    }
}


