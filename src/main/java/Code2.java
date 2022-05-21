/***
 * 2) Sum of Digits / Digital Root (6 kyu)
 * https://www.codewars.com/kata/541c8630095125aba6000c00
 * Для тренировки, рекурсия
*/



public class Code2 {

    public static int sumOfDigits(String str) {
        int result=0;

        for (int i = 0; i <= str.length() - 1; i++) {
            result=result+Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        if (Integer.toString(result).length()>1){
            result=sumOfDigits(String.valueOf(result));
        }
        return result;
    }

    public static void main(String[] args) {
        String inText = "493193";
        System.out.println((inText));
        System.out.println(sumOfDigits(inText));
    }
}
