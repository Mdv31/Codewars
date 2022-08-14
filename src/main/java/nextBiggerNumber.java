import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class nextBiggerNumber {
    public static int foundKey(long n) {
        String[] inText = String.valueOf(n).split("");
        int i = 0;

        for (i = inText.length - 1; i > 0; i--) {
            if (Long.parseLong(inText[i]) > Long.parseLong(inText[i - 1])) {
                break;
            }
        }
        return i;
    }

    public static long nextBiggerNumber(long n) {
        System.out.println(n + "<< Входящие число");
        String[] inText = String.valueOf(n).split("");

        int i = foundKey(n);

        if (i == 0) {
            return -1;
        }

        String rightText = Arrays.stream(String.valueOf(n).substring(i, inText.length).split(""))
                .collect(Collectors.joining(""));
        //
        System.out.println(rightText + " << rightText");

        //найти минимальный элемент в правой части по отношению к i-1
        String minRight = Arrays.stream(rightText.split(""))
                .filter((x) -> Long.parseLong(x) > Character.getNumericValue(String.valueOf(n).charAt(i - 1)))
                .min(Comparator.naturalOrder())
                .get();

        //левая, статичная часть числа. добавляем символ мин Райт в левую часть и удаляем его из правой части
        String leftText = String.valueOf(n).substring(0, i - 1) + minRight;
        rightText = rightText.replaceFirst(minRight, "");

        rightText = String.valueOf(n).charAt(i - 1) + rightText;

        //сортировка правой части
        rightText = Arrays.stream(rightText.split("")).sorted().collect(Collectors.joining(""));

        System.out.println(i + " << key");
        System.out.println(leftText + " << leftText");
        System.out.println(String.valueOf(n).charAt(i) + " << char i (кей)");
        System.out.println(rightText + " << rightText");
        System.out.println(String.valueOf(n).charAt(i - 1) + " << char i-1");
        System.out.println(minRight + " << minRight");
        System.out.println(leftText + "   " + rightText);

        return Long.parseLong(leftText + rightText);
    }
}
//вход 1129265632
//правый сивол больше левого i (6) > i-1 (5)
// 1129265 632
//найти наименьшкю цифру больше i-1 (5) справа >> 632 -> 6
// 1129265 6 32
//поместите его слева от i-1 (5)
// 112926 6 532
//сортировка правой части (532)
// 112926 6 235


