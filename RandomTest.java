import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    public static void main(String[] args) {
        /**
         * Math.random()
         * The Java Math class has many methods for different
         * mathematical operations. One of them is the random() method.
         * It is a static method of the Math class. We can invoke it directly.
         * It generates only double type random number
         * greater than or equal to 0.0 and less than 1.0. Before using the
         * random() method, we must import the java.lang.Math class.
         * 
         * It does not accept any parameter. It returns a pseudorandom double
         * that is greater than or equal to 0.0 and less than 1.0.
         */
        System.out.println(Math.random());
        System.out.println(Math.random());

        /**
         * We can also use the following formula if we want to a generate
         * random number between a specified range.
         */
        int min = 200;
        int max = 400;
        // Generate random double value from 200 to 400
        System.out.println("Random value of type double between " + min + " to " + max + ":");
        double a = Math.random() * (max - min + 1) + min;
        System.out.println(a);

        /**
         * Another way to generate a random number is to use the Java Random class
         * of the java.util package. It generates a stream of pseudorandom numbers.
         * We can generate a random number of any data type, such as integer, float,
         * double, Boolean, long.
         */

        Random random = new Random();
        System.out.println(random.nextInt(6));
        System.out.println(random.nextInt());

        System.out.println("Using the ThreadLocalRandom Class " + ThreadLocalRandom.current().nextInt());

        // Random Number Generation in Java 8
        /**
         * In Java 8, a new method ints() has been added to the Random class.
         * We must import the java.util.Random before using the method.
         * ints(): The pseudorandom int values generated the same as calling
         * the nextInt() method. It returns an unlimited stream of pseudorandom int
         * values.
         */
        random.ints(3).forEach(System.out::println);

    }
}

/*
 * References: https://www.javatpoint.com/how-to-generate-random-number-in-java
 */
