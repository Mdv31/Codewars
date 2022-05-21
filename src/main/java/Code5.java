/***
 * 1) Реализуйте функцию, возвращающую двоичное представление числа n(n>=0).
 * например, 101 - это двоичное представление числа 5.
 * Метод должен иметь сигнатуру String tobinary(int number)
 * */

public class Code5 {
    public static String tobinary(int number){
        String binary=Integer.toBinaryString(number);
        return binary;
    }

    public static String tobinary2(int number){
        String binary="";

        if (number==0) return binary="0";

        while (number >0){
            if (number%2==0)
                binary=binary+"0";
            else binary=binary+"1";
            number=number/2;
        }
        //возвращаем результат в обратном порядке
        return new StringBuilder(binary).reverse().toString();
    }

    public static void main(String[] args) {
        int number = 156;
        System.out.println(tobinary(number));
        System.out.println(tobinary2(number));
    }
}
