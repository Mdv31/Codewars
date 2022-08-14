/***
 * 4) Реализуйте метод, определяющий, является ли одна строка перестановкой другой.
 * Под перестановкой понимаем любое изменение порядка символов.
 * Регистр учитывается, пробелы являются существенными
 */

public class Code8 {

    public static boolean equalSwap(String inText, String outText) {
        if (inText.length() != outText.length()) return false;

        for (int i = 0; i < inText.length(); i++)
            if (outText.contains(String.valueOf(inText.charAt(i)))) {
                outText = outText.replaceFirst(String.valueOf(inText.charAt(i)), "");
            } else return false;

        return true;
    }

    public static void main(String[] args) {
        String inText = "13 2";
        String outText = "13 2";

        System.out.println(equalSwap(inText, outText));

    }
}
