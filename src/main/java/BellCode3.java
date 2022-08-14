/**
 * Дан массив NxN. Напишите программу на Java которая находит минимальный элемент побочной диагонали, без учёта элемента пересечения главной и побочной диагонали.
 * Для примера приведена матрица 5х5. Побочная диагональ выделена жирным, минимальный элемент побочной диагонали – красным и подчёркнут:
 * 1	2	3	4	5
 * 5	7	9	2	1
 * 0	9	1	8	7
 * 6	3	6	6	6
 * 99 	100	-2	3	1
 */

public class BellCode3 {

    public static void findMinElementDiagonal(int[][] massivNN) {
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = massivNN.length - 1; i >= 0; i--) {
            if (i != j && massivNN[i][j] < min)
                min = massivNN[i][j];
            j = j + 1;
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int[][] massivNN = new int[][]{
                {1, 2, 3, 4, -11},
                {5, 7, 9, 20, 1},
                {0, 9, -100, 8, 7},
                {6, 3, 6, 6, 6},
                {99, 100, -2, 3, 1}
        };
        findMinElementDiagonal(massivNN);

    }


}
