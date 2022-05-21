/***
 * 2) Напишите функцию, меняющую местами значения переменных, не используя временные переменные.
 */

public class Code6 {

    public static String swap(String first, String second){
        first=first+second;
        second=first.substring(0,first.length()-second.length());
        first=first.substring(second.length(),first.length());
        return first+second;
    }

    public static String swap(int inFirst, int inSecond){
        String first=Integer.toString(inFirst);
        String second=Integer.toString(inSecond);
        first=first+second;
        second=first.substring(0,first.length()-second.length());
        first=first.substring(second.length(),first.length());
        return first+second;
    }

    public static void main(String[] args) {
        String first = "First123";
        String second = "Second321321";

        System.out.println(first+second);
        System.out.println(swap(first,second));
        System.out.println(swap(111,22222));
    }
}
