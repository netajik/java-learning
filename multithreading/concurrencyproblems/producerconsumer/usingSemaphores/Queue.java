package multithreading.concurrencyproblems.producerconsumer.usingsemaphores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Queue {
    
    private int item;
    Semaphore prodSemaphore;
    Semaphore conSemaphore;

    Queue() {
        prodSemaphore = new Semaphore(1);
        conSemaphore = new Semaphore(0);
    }

    void setItem(int value) {
        this.item = value;
    }

    int getItem() {
        return this.item;
    }

    void get() {
        try{
            conSemaphore.acquire();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Consumed Item: "+this.item);
        prodSemaphore.release();
    }

    void put() {
        try{
            prodSemaphore.acquire();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        this.item = new Random().nextInt(5);
        System.out.println("Item Produced: "+this.item);
        conSemaphore.release();
    }
}
