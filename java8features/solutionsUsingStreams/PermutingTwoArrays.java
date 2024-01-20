package java8features.solutionsUsingStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * There are two n-element arrays of integers,  A and B . Permute them into some A' and B' 
 * such that the relation A'[i]+B'[i]>=k holds for all  where 0<=i<n.
 * There will be  queries consisting of A, B, and k . For each query, 
 * return YES if some permutation A',B satisfying the relation exists. Otherwise, return NO.
 */
public class PermutingTwoArrays {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1,0));
        List<Integer> list2 = new ArrayList<>(List.of(1,0));
        String result = twoArrays(1,list1, list2);
        System.out.println(result);
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        return IntStream.range(0, A.size()).filter(i -> A.get(i) + B.get(i) < k).count() > 0 ? "NO" : "YES";
    }
}
