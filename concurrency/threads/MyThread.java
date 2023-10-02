package com.javabasics.multithreading;

/**
 * User defined Thread creation using Thread class
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<3;i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
        }
    }
}

/**
* Thread creation using Runnable interface
 */
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("User defined thread using runnable interface..!"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        if(true);
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        new Thread(myRunnable).start();
        //Using lamda expression
        new Thread(()->System.out.println(Thread.currentThread().getName())).start();
    }
}
