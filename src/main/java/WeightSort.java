import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {

    public static String orderWeight(String strng) {
        System.out.println(strng);
        // your code
        String result = Arrays.stream(strng.split(" "))
                .sorted(Comparator.comparing(WeightSort::sumWeight).thenComparing(x->x)) //фильтр по весам, за тем по алфавиту (если вес равны)
                .collect(Collectors.joining(" "));

        System.out.println(result);
        return result;
    }

    public static int sumWeight(String strng) {
        return Arrays.stream(strng.split("")).mapToInt(Integer::parseInt).sum();
    }
}
