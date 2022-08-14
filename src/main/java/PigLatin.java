import java.util.ArrayList;

public class PigLatin {
    public static String pigIt(String str) {

        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");

        /*
        // Write code here
        System.out.println(str);
        //разделить строку на слова
        String result="";
        String[] words=str.split(" ");

        for (String value : words){
            // проверка, что первый символ Буква
            if(Character.isLetter(value.charAt(0))){
                value=value+value.charAt(0)+"ay";
                value=value.substring(1, value.length());

                result=result+" "+value;
            }
            else result=result+" "+value;
        }
        System.out.println(result);
        return result.trim();*/
    }
}

