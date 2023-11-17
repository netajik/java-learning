package multithreading.threads;

public class ThreadPriority extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }


    public static void main(String[] args) {
        ThreadPriority t = new ThreadPriority();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        //System.out.println(t1);
    }

    //Note
    /**
     * Thread priority in programming indicates task importance. However, it's not a strict rule;
     * different computers may interpret it differently. The computer's scheduling plan might favor
     * less important tasks, and changing priority on-the-fly doesn't guarantee immediate adjustments.
     * Group rules and system intricacies play a role, and high priority doesn't always mean
     * faster execution. It's a suggestion to the computer rather than a fixed command.
     *
     * In practice, relying heavily on thread priority for application logic is discouraged due to
     * the lack of guarantees in its behavior across different systems. It's often better to design
     * concurrent systems that are less dependent on specific thread priorities and more robust to
     * variations in thread scheduling. Using higher-level concurrency constructs from the
     * java.util.concurrent package is also recommended for building reliable concurrent applications.
     */
}

