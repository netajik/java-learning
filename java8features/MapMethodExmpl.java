package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * map method used to perform opetations on every element in sequence.
 * map method internall uses Functional interface and it contains apply abstract method.
 * To define apply method of Functional interface, we can use lambda expression
 * as shwon below.
 */
public class MapMethodExmpl {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 3, 2, 4, 5, 6, 7, 3, 4, 5);
        List<Integer> result1 = list1.stream().map(num -> num + 2).collect(Collectors.toList());
        System.out.println(result1);

        // 4,3,4,5,6,7,2,3,4 filter even number and multiply every number with 10
        List<Integer> list2 = List.of(4, 3, 4, 5, 6, 7, 2, 3, 4);
        List<Integer> result2 = list2.stream().filter(num -> num % 2 == 0).map(num -> num * 10)
                .collect(Collectors.toList());
        System.out.println(result2);

        List<Employee> employees = List.of(new Employee(1, "raju", 100d),
                new Employee(2, "ravi", 15000d),
                new Employee(3, "ramu", 15000d));

        // Here map only applied on name and it returns name only not object. If we want
        // Employee object then we have to write custom logic to get it.
        System.out.println();
        employees.stream().map(employee -> employee.ename + "it").forEach(name -> System.out.println(name));

        System.out.println();
        System.out.println("Employee object printing using map");
        employees.stream().map(employee -> {
            employee.ename = employee.ename.concat("it");
            return employee;
        }).forEach(employee -> System.out.println(employee));
    }
}
