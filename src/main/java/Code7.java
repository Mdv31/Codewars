/***
 * 3) Напишите метод, находящий максимальное из двух чисел,
 * не используя операторы if-else или любые другие операторы сравнения.
 */

public class Code7 {
    public static long max(int a, int b){
        long result = (long) ((a+b+Math.sqrt(a*a-2*a*b+b*b))/2);
        System.out.println(result);
        return result;
    }

    public static int min(int a, int b){
        int result = (int) ((a+b-Math.sqrt(a*a-2*a*b+b*b))/2);
        return result;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 5;
        System.out.println("In: "+a+" "+b);
        System.out.println("max: "+max(a,b));
        System.out.println("min: "+min(a,b));
    }
}
