package com.javabasics.multithreading;

/**
 * Daemon Threads are working in background to support main threads
 * Daemon Thread stop if we stop main thread
 */
 class DThread extends Thread{
    public void run() {
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: "+Thread.currentThread().getName());
        }
    }
}

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        DThread dThread = new DThread();
        dThread.setDaemon(true);
        dThread.start();
        for(int i=0;i<2;i++) {
            Thread.sleep(1000);
            System.out.println("Main thread");
        }
    }
}


