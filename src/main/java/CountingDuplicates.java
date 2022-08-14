import java.util.Locale;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        // делаю все буквы маленькими
        text=text.toLowerCase(Locale.ROOT);
        String finalText = text;
        int countCh=0;

        // цикл перебора символов
        for(int i =0; i<text.length(); i++){
            int finalI = i;
            // если символ повторяется более 1 раза двигаем счетчик
            if (text.chars().filter(ch -> ch == finalText.charAt(finalI)).count() > 1) countCh++;
            // обработаные символы заменяем на " "
            text=text.replaceAll(String.valueOf(text.charAt(i))," ");
        }
        return countCh;
    }
}