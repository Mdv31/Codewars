/***
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged
 * to match str2, otherwise returns false.
 *
 * Notes:
 *
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered.
 *
 * */

public class Scramblies {

    public static boolean scramble(String str1, String str2) {

        // your code
        boolean scrambleFlag = false;
        for(int i=0; i<str2.length();i++){

            if (str1.contains(Character.toString(str2.charAt(i)))){
                str1=str1.replaceFirst(Character.toString(str2.charAt(i)),"");
                scrambleFlag = true;
            }
            else return false;
        }
        return scrambleFlag;
    }
}