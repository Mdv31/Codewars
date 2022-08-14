import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

class ClosestWeight {
    public static int[][] closest(String strng) {
        // your code
        //Если пустая строка - пустой ответ
        int[][] resultNull = new int[0][0];
        if (strng == "") return resultNull;

        //System.out.println("\n\n"+strng);
        //функиция поиска суммы цифр числа
        String[] digit = strng.split(" ");
        int[][] result = new int[digit.length][3];

        for (int i = 0; i < digit.length; i++) {
            int sum = 0;
            for (int j = 0; j < digit[i].length(); j++) {
                sum = sum + Integer.parseInt(String.valueOf(digit[i].charAt(j)));
            }
            //добавляем элемент [вес, индекс,число] --- [sum,i,digit[i]]
            result[i][0] = sum;
            result[i][1] = i;
            result[i][2] = Integer.parseInt(digit[i]);

        }
        // определения поиск чисел с наименьшей разнецой весов
        // создадим матрицу размером по кол-ву элементов, значение ij = разнице весов
        int[][] sumMinus = new int[digit.length][digit.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < digit.length; i++) {
            for (int j = 0; j < digit.length; j++) {
                if (i > j) {
                    sumMinus[j][i] = abs(result[j][0] - result[i][0]);
                    //System.out.print(sumMinus[j][i]+ "\t");
                    if (min > sumMinus[j][i]) {
                        min = sumMinus[j][i];
                    }
                }
            }
            //System.out.println(" ");
        }
        //подготовка ответа, выбираем все элементы где разница сумм минимальна
        int[][] answer = new int[2][3];

        for (int i = 0; i < digit.length; i++) {
            for (int j = 0; j < digit.length; j++) {
                if (sumMinus[j][i] == min && i>j ) {
                    //если ответ пустой, записываем первые минимальные элементы
                    //если вес ответа больше, чем нового ответа - записываем
                    // если веса ответа равны, записываем с меньшим инджексом
                    /*|| ( (answer[0][0] == result[j][0] || answer[1][0] == result[i][0])
                                    && (answer[0][1] > result[j][1] || answer[1][1] > result[i][1])
                            )*/
                    if (answer[0][0] == 0 && answer[0][1] == 0&&answer[0][2] == 0) {

                        //System.out.println("\n!!! j,i:" + j + "," + i + "   min:" + min + "   res:" + result[j][0] + "," + result[i][0] + "   ans:" + answer[0][0] + "," + answer[1][0]);
                        //System.out.println("1 "+answer[0][0] + ">" + result[j][0] + "\t" + answer[1][0] + ">" + result[i][0]);
                        answer[0][0] = result[j][0];
                        answer[0][1] = result[j][1];
                        answer[0][2] = result[j][2];
                        //System.out.println(Arrays.toString(answer[0]));
                        answer[1][0] = result[i][0];
                        answer[1][1] = result[i][1];
                        answer[1][2] = result[i][2];
                        //System.out.println(Arrays.toString(answer[1]));
                    } else if (answer[0][0] > result[j][0] || answer[1][0] > result[i][0]) {

                        //System.out.println("\n!!! j,i:" + j + "," + i + "   min:" + min + "   res:" + result[j][0] + "," + result[i][0] + "   ans:" + answer[0][0] + "," + answer[1][0]);
                        //System.out.println("2 "+answer[0][0] + ">" + result[j][0] + "\t" + answer[1][0] + ">" + result[i][0]);
                        answer[0][0] = result[j][0];
                        answer[0][1] = result[j][1];
                        answer[0][2] = result[j][2];
                        //System.out.println(Arrays.toString(answer[0]));
                        answer[1][0] = result[i][0];
                        answer[1][1] = result[i][1];
                        answer[1][2] = result[i][2];
                        //System.out.println(Arrays.toString(answer[1]));
                    }
                }
            }
        }
        //сортировка массива ансвер по весам перед ретурном
        //Два подмассива сортируются в порядке возрастания по их числовым весам,
        // если эти веса различны, по их индексам в строке, если они имеют одинаковые веса.

        for (int i =0; i<answer.length-1; i++){
            if (answer[i][0]>answer[i+1][0]){
                int sumTemp=answer[i][0];
                int iTemp=answer[i][1];
                int digitTemp=answer[i][2];
                answer[i][0]= answer[i+1][0];
                answer[i][1]= answer[i+1][1];
                answer[i][2]= answer[i+1][2];
                answer[i+1][0]= sumTemp;
                answer[i+1][1]= iTemp;
                answer[i+1][2]= digitTemp;
            }
        }

        return answer;
    }
}

//https://www.codewars.com/kata/5868b2de442e3fb2bb000119/train/java

/*
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)

        //сплит строки по 3 пробелам
        // для каждого элемента сплита вызываем функцию кода морзе MorseCode.get(".--") и записываем на вывод

        return Arrays.stream(morseCode.trim().split(" "))
                .map( (x) -> MorseCode.get(x))
                .collect(Collectors.joining(""))
                .toString().trim().replaceAll("nullnull", " ");
    }
}*/

/***
 * MorseCodeDecoder v2
 * https://www.codewars.com/kata/54b72c16cd7f5154e9000457/train/java
 * */
/*
public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
        System.out.println("\n\n>>>"+bits+"<<< входящая строка \n");
        bits=bits.trim();
        if(bits.matches("0?1+0?")){return ".";} //0+?1+0+?

        // Arrays.stream(bits.split("1+")).forEach(System.out::println);
        // Arrays.stream(bits.split("1+")).filter(x-> x !="").forEach(x-> System.out.println(x+"   "+x.length()));

        int time= Arrays.stream(bits.split("0+")).filter(x-> x !="").min(Comparator.comparing(s -> s.length())).get().length();
        int time1= Arrays.stream(bits.split("1+")).filter(x-> x !="").min(Comparator.comparing(s -> s.length())).get().length();

        if (time1<time) time=time1;
        System.out.println(time+" <<< временной показатель \n");

        char[] bits1=bits.toCharArray();
        bits="";
        for (int i=0; i<bits1.length; i=i+time){
            bits=bits+ bits1[i];
        }
        System.out.println(bits+" <<< с корректированная строка по временному показателю \n");

        return bits
                .replace("111", "-")
                .replace("1", ".")
                .replace("0000000", "   ")
                .replace("000", " ")
                .replace("0", "");
    }


    public static String decodeMorse(String morseCode) {
        System.out.println(morseCode+" <<< код Морзе \n");
        return Arrays.stream(morseCode.trim().split(" "))
                .map( (x) -> MorseCode.get(x))
                .collect(Collectors.joining(""))
                .toString().trim().replaceAll("nullnull", " ");
    }
}
*/
/***
 *  * MorseCodeDecoder - v Best
 * */
/*
public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
        bits = bits.replaceAll("^0*|0*$", "");
        int timeUnit = Pattern.compile("0+|1+")
                .matcher(bits)
                .results()
                .map(MatchResult::group)
                .mapToInt(String::length)
                .min()
                .orElseGet(bits::length);
        return bits.replace("111".repeat(timeUnit), "-")
                .replace("000".repeat(timeUnit), " ")
                .replace("1".repeat(timeUnit), ".")
                .replace("0".repeat(timeUnit), "");
    }

    public static String decodeMorse(String morseCode) {
        String decoded = "";
        for (String word : morseCode.split(" "))
            if (word.equals("")) decoded += " ";
            else decoded += MorseCode.get(word);
        return decoded;
    }
}
*/