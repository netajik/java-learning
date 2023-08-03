package java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMethod {
   public static void main(String[] args) {
      /**
       * sort method used to sort the data
       * To sort data, must follow two rules
       * 1. Data must be homogenous.
       * 2. implements comparable interface.
       * Note: In java only String, All wrapper class are implement Comparable
       * interface.
       * The sorting is done using compareTo() method.
       */

      /**
       * Three sorts are available in java
       */

      // 1. Collections sort

      List<String> list1 = Arrays.asList("hello", "ahi", "world");
      Collections.sort(list1, Comparator.reverseOrder());
      System.out.println(list1);

      // Note: Comparator contains compare(T1,T2) method, in this method we will
      // perform the sorting operation using compareTo() method.

      // 2. list.sort()
      List<String> list2 = Arrays.asList("hello", "ahi", "world");
      list2.sort((name1, name2) -> -name1.compareTo(name2));
      System.out.println(list2);

      // 3. stream.sort()
      List<String> list3 = Arrays.asList("hello", "ahi", "world");
      list3.stream().sorted((name1, name2) -> -name1.compareTo(name2)).forEach(num -> System.out.println(num));

      // Note: If only sorting required then we use first or second approch. If we
      // have to any filter or maping
      // along with sorting then use stream sort

      // using method reference
      System.out.println();
      System.out.println("Using method reference and stream");
      list3.stream().sorted(String::compareTo).forEach(num -> System.out.println(num));

   }
}
