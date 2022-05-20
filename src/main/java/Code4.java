/***Написать функцию которая находит в массиве int[] число, наиболее близкое к 10.
 Если таких чисел два (например 8 и 12), то выбрать большее из них.
*/

 public class Code4 {

    public static int digits(int[] array) {
    int [] k = new int[array.length];
    int best=0;
        for (int i = 0; i <= array.length - 1; i++) {
            k[i]=Math.abs(array[i]-10);
            if (i==0){ best=i;}
            if (i >0 && k[i]==0) {best=i; break;}
            if (i >0 && k[i]<k[best]) {
                best = i;
            }
            if (i>0 && k[i]==k[best] && array[i] >= array[best]){
                best=i;
            }

        }
        return array[best];
    }

    public static void main(String[] args) {
        int [] array= {5,6,11,9,7,12,18};
        System.out.println(digits(array));
    }
}
