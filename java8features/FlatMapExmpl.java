package java8features;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Flatmap used to convert collection of collection objects into single collection.
 * Example converting list of lists into single list.
 */
public class FlatMapExmpl {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(List.of(2, 3, 4, 5), List.of(7, 6, 5, 4));
        List<Integer> list = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(list);

        Set<Set<Integer>> sets = Set.of(Set.of(2, 3, 4, 5), Set.of(7, 6, 5, 4));
        Set<Integer> set = sets.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        System.out.println(set);

        List<Map<Integer, String>> maps = List.of(Map.of(2, "a", 3, "b", 4, "c", 5, "d"),
                Map.of(7, "e", 6, "f", 5, "g", 4, "h"));
        List<Entry<Integer, String>> list1 = maps.stream()
                .flatMap(data -> data.entrySet().stream()).collect(Collectors.toList());
        System.out.println(list1);
    }
}
