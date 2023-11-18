package multithreading.concurrencyproblems.producerconsumer.usingsemaphores;

public class Consumer extends Thread{
    Queue queue;
    Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            this.queue.get();
        }
    }
}
