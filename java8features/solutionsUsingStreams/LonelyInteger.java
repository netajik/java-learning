package java8features.solutionsUsingStreams;

import java.util.List;

/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 */
public class LonelyInteger {
    public static void main(String[] args) {
        System.out.println(lonelyinteger(List.of(1,2,3,4,3,2,1)));
    }

    public static int lonelyinteger(List<Integer> list) {
        return list.stream().reduce((b,c)->b^c).get();
    }
}
