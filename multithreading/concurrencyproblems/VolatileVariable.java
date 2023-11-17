package multithreading.concurrencyproblems;

/**
 * Volatile ensures, that a certain, expected (memory) state is true across
 * different threads.
 * https://stackoverflow.com/questions/19744508/volatile-vs-atomic
 */
public class VolatileVariable {

    /**
     * Volatile key work used to solve visibility problem. if we declare any
     * with volatile then that variable is available across all threads.\
     *
     * https://www.youtube.com/watch?v=WH5UvQJizH0&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=1
     * https://www.geeksforgeeks.org/volatile-keyword-in-java/
     *
     */
    private static volatile int MY_INT = 0;
    // Note: test with and without volatile keyword, then we will the different
    // results.

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            System.out.println("In Change Listener");
            while (local_value < 5) {
                if (local_value != MY_INT) {
                    System.out.println("Got Change for MY_INT : " + MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            System.out.println("In ChangeMaker");
            while (MY_INT < 5) {
                System.out.println(
                        "Incrementing MY_INT to " +
                                (local_value + 1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }
}
