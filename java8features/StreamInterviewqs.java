package java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamInterviewqs {
    public static void main(String[] args) {
        System.out.println("Q1");
        // You are given list of names, Print the names which doesn't start from 'a'
        // using Java Stream APIs.
        List<String> names = List.of("dd", "Aa", "arr", "ff");
        names.stream().filter(name -> !name.toLowerCase().startsWith("b")).forEach(System.out::println);
        // another approach: pass Predicate.not(name -> name.startsWith("a") to filter.

        System.out.println("\nQ2");
        // You are given list of countires, count of number of occurrences of each
        // country and print them in ascending order of names.

        // Create a map to store country counts
        Map<String, Integer> countryCounts = new HashMap<>();

        // Add country counts to the map
        countryCounts.put("USA", 10);
        countryCounts.put("Canada", 5);
        countryCounts.put("India", 8);
        countryCounts.put("Australia", 3);

        System.out.println("Approach 1");

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(countryCounts.entrySet());
        Collections.sort(entries, (a, b) -> a.getKey().compareTo(b.getKey()));
        entries.forEach(entry -> System.out.println(entry.getKey()));

        System.out.println("\nApproach 2");

        countryCounts.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey()));

        System.out.println("\nQ3");
    }
}
