package java8features;

import java.util.List;

public class RecudeMethodExmpl {
 public static void main(String[] args) {
    /**
     * Reduce method perform operation on all values/collection data and returns only one value
     * For example to get sum of all prices, we can use reduce method.
     */
    List<Integer> prices = List.of(4,3,2,5,6,7,2);
    Integer sum = prices.stream().reduce((num1,num2)->num1+num2).get();
    System.out.println("Sum: "+sum);

    /**
     * names: aaa,bb,rr,ee,gg,rgr,ee,rer,de,ddw,tt
     * fileter based on start with 'r' or 'd'  and length >= 2
     * Add "it" to every String
     * combine all strings.
     */
    List<String> names = List.of("aaa","bb","rr","ee","gg","rgr","ee","rer","de","ddw","tt");
    String result = names.stream()
        .filter(name->(name.startsWith("d")||name.startsWith("r"))&&name.length()>=2)
        .map(name->name+"it")
        .reduce((name1,name2)->name1+name2)
        .get();  
    System.out.println(result);
 }
}
