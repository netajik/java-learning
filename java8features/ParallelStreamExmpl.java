package java8features;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Parallel stream takes less time then sequential stream.
 * Parallel streams runs on multiple processors and reduce processing time.
 * Order of result different campare to sequential stream
 */
public class ParallelStreamExmpl {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 4, 5, 1, 3);

        System.out.println("Parallel Stream");
        Long startParl = System.currentTimeMillis();
        List<Integer> result1 = list.parallelStream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        Long endParl = System.currentTimeMillis();
        System.out.println("Parallel stream time: " + (endParl - startParl));

        System.out.println("\nSequential Stream");
        long startSeq = System.currentTimeMillis();
        List<Integer> result2 = list.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        long endSeq = System.currentTimeMillis();
        System.out.println("Sequential stream time: " + (endSeq - startSeq));
    }
}
