package java8features;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilterExmpl {

    public static void main(String[] args) {
        List<Integer> list = List.of(3, 4, 2,10, 6, 7,8,6,4);
        // using forEach
        /**
         * ForEach internally uses functional interface Consumer. So using lambda we can
         * implement method in consumer interface by passing lambda expression to forEach.
         */
        // Example filter even data
        list.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.println(num));

        // using Collectors to collect data
        /**
         * filter internall uses Predicate functional interface. So we can pass lambda expression
         * as an implementation of abstract method in predicate interface to filter method.
         */
        // Example filter even data
        List<Integer> result = list.stream().filter(num->num%2==0).collect(Collectors.toList());
        System.out.println("list elements: "+result);
        Set<Integer> set = list.stream().filter(num->num%2==0).collect(Collectors.toSet());
        System.out.println("Set elelments: "+set);

        // count
        System.out.println("count: "+list.stream().filter(num->num%2==0).count());

        // find first
        int first = list.stream().filter(num->num%2==0).findFirst().get();
        System.out.println("first: "+first);

        // To get specefic element, for that we have to skip all elements before that. To get third 
        // element we have to skip 2 elements before 3rd elemnt.
        int speceficelement = list.stream().filter(num->num%2==0).skip(2).findFirst().get();
        System.out.println("speceficelement: "+speceficelement);
    }
}
