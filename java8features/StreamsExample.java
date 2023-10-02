package com.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Note:
 * Introduced in Java 8, the Stream API is used to process collections of objects.
 * A stream is a sequence of objects that supports various methods which can be
 * pipelined to produce the desired result.
 * The features of Java stream are –
 *
 * A stream is not a data structure instead it takes input from the Collections,
 * Arrays or I/O channels.
 * Streams don’t change the original data structure, they only provide the result
 * as per the pipelined methods.
 * Each intermediate operation is lazily executed and returns a stream as a result,
 * hence various intermediate operations can be pipelined. Terminal operations mark
 * the end of the stream and return the result.
 */

public class StreamsExample {

    public static void main(String[] args) {

        //optional class demo
        //It can help in writing a neat code without using too many null checks.
        String[] strings = new String[10];
        Optional<String> optional = Optional.ofNullable(strings[5]);
        if(optional.isPresent()){
            System.out.println(strings[5].toLowerCase());
        } else {
            System.out.println("empty string");
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }


        /**
         * Reduced Lines of Code One of the clear benefit of using lambda
         * expression is that the amount of code is reduced,
         *
         Sequential and Parallel Execution Support Another benefit of using
         lambda expression is that we can benefit from the Stream API sequential
         and parallel operations support.
         */

        /**
         * Notice that parallel processing values are not in order,
         * so parallel processing will be very helpful while working
         * with huge collections.
         */

        //sequential stream
        Stream<Integer> stream = list.stream();
        stream.filter(p->p>5).forEach(System.out::print);
        System.out.println();

        //parallel stream with filter
        Stream<Integer> parallelStream = list.parallelStream();
        parallelStream.filter(p->p>5).forEach(p->System.out.print(p));
        System.out.println();

        //map
        List result = list.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println(result);
        System.out.println();

        //sort
        List names = Arrays.asList("Reflection","Collection","Stream");
        List sortedNames = (List) names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);

        //reduce
        System.out.println("reduce "+list.stream().reduce(0,(ans,i)->ans+i));

        System.out.println(isPrimeUsingStream(5));
        System.out.println(sumwithcondition(list, i->i%2==0));

    }

    //Traditional approach
    private static boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i=2; i<number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    //Declarative approach
    private static boolean isPrimeUsingStream(int number){
        IntPredicate isDivisible = index->number%index==0;
        return number>1 && IntStream.range(2,number).noneMatch(isDivisible);
    }

    private static int sumwithcondition(List<Integer> list, Predicate<Integer> predicate) {

        return list.stream().filter(predicate).mapToInt(i -> i).sum();
    }

}
