package java8features;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class StreamApi {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 6, 2, 7);
        Predicate<Integer> predicate = t -> t % 2 == 0;

        int result = list.stream().filter(predicate).map(i -> i * i).reduce((r, e) -> r + e).get();
        System.out.print(result);
    }
}