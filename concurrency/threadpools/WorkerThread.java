
import java.util.concurrent.*;

public class WorkerThread implements Runnable {

    private String command;

    WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start. Command " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + "End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("All Threads finished.");
    }
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected");
    }
}

class MyMonitorThread implements Runnable {

    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    MyMonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.seconds = delay;
    }

    public void shutdown() {
        this.run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out.println(
                    String.format("[monitor][%d%d] Active: %d, " +
                            "completed: %d, Task: %d, " +
                            "isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectedExecutionHandler);
        MyMonitorThread monitor = new MyMonitorThread(threadPoolExecutor, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(new WorkerThread("cmd" + i));
        }

        Thread.sleep(30000);
        threadPoolExecutor.shutdown();
        Thread.sleep(5000);
        monitor.shutdown();
    }
}

class Task implements Runnable {
    private String s;

    Task(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.s);
    }
}

class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Task("schedule with delay 10"), 10, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Task("schedule at fixed rate"), 15, 10, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new Task("schedule at fixed rate and delay"), 15, 10,
                TimeUnit.SECONDS);
    }
}

/**
 * References
 * https://www.digitalocean.com/community/tutorials/threadpoolexecutor-java-thread-pool-example-executorservice
 *
 */