import java.util.ArrayList;

/***
 * 3) Сумма интервалов
 * https://www.codewars.com/kata/52b7ed099cdc285c300001cd
 * Для тренировки
 */

public class Code3 {

    public static int sumIntervals(int[][] intervals) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int [] row : intervals) {
            for (int k = row[0]; k < row[1]; k++) {
                if (!values.contains(k)) {
                    values.add(k);
                }
            }
        }
        return values.size();
    }

    public static void main(String[] args) {
        int[][] intervals={
                {1, 5},
                {10, 20},
                {1, 6},
                {16, 19},
                {5, 11}
        };//19
        System.out.println(sumIntervals(intervals));
    }
}
