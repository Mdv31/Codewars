/***
 * 1) Stop gninnipS My sdroW! (6 kyu)
 * https://www.codewars.com/kata/5264d2b162488dc400000001
 * Для тренировки, решить без split() и reverse()
 */

public class Code1 {

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }

    public static String[] splitString(String delimiter, String str) {
        char[] array = str.toCharArray();
        int wordCount=1;

        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] == delimiter.charAt(0)) {
                wordCount++;
            }
        }

        String[] result = new String[wordCount];
        int j=0;
        result[j]="";
            for (int i = 0; i <= array.length - 1; i++) {
                if (array[i] == delimiter.charAt(0)) {
                    j++;
                    result[j]="";
                }
                else {
                    result[j] = result[j] + array[i];
                }
            }
        return result;
    }

    public static String mySdrow(String inText) {
        String[] words = splitString(" ", inText);
        String outText = "";
        for (String word : words) {
            if (word.length()<5) {
                if (outText.contentEquals(""))
                    outText = word;
                else
                    outText = outText+" "+word;
            }
            else{
                if (outText.contentEquals(""))
                    outText=reverseString(word);
                else
                    outText=outText+" "+reverseString(word);
            }
        }
        return outText;
    }

    public static void main(String[] args) {
        String inText = "qwerty 12345 1234 qwe asdfgh q";
            System.out.println(inText);
            System.out.println(mySdrow(inText));
    }
}