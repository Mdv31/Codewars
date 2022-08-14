import java.util.Arrays;

public class BattleField {

    public static int checkSum(int[][] fieldZero, int i, int j){
        int sum=0;
        // поиск 1 клеточного кораблей
        if (fieldZero[i-1][j+1]+fieldZero[i][j+1]+fieldZero[i+1][j+1]+
                fieldZero[i-1][j]+fieldZero[i][j]+fieldZero[i+1][j]+
                fieldZero[i-1][j-1]+fieldZero[i][j-1]+fieldZero[i+1][j-1]==1) {
            sum = 1;
        }
        //поиск 2х клеточного корабля
        if ((fieldZero[i][j]+fieldZero[i+1][j]==2 && fieldZero[i-1][j]==0 && fieldZero[i+2][j]==0)||
                (fieldZero[i][j]+fieldZero[i][j+1]==2 && fieldZero[i][j-1]==0 && fieldZero[i][j+2]==0)){
            sum=2;
        }
        //поиск 3х клеточного корабля
        if ((fieldZero[i][j]+fieldZero[i+1][j]+fieldZero[i+2][j]==3 && fieldZero[i-1][j]==0 && fieldZero[i+3][j]==0)||
                (fieldZero[i][j]+fieldZero[i][j+1]+fieldZero[i][j+2]==3 && fieldZero[i][j-1]==0 && fieldZero[i][j+3]==0)){
            sum=3;
        }
        //поиск 4х клеточного корабля
        if (fieldZero[i][j]+fieldZero[i+1][j]+fieldZero[i+2][j]+fieldZero[i+3][j]==4 ||
                fieldZero[i][j]+fieldZero[i][j+1]+fieldZero[i][j+2]+fieldZero[i][j+3]==4){
            sum=4;
        }
        return sum;
    }

    public static boolean fieldValidator(int[][] field) {
        // your code here!

        //проверка, что 20 ячеек занято кораблями
        int sumShips = Arrays.stream(field).flatMapToInt(Arrays::stream).sum();
        if (sumShips!=20) return false;

        //объявить перменные счетчика кораблей
        int oneShipCount = 0;
        int twoShipCount = 0;
        int threeShipCount = 0;
        int fourShipCount = 0;

        //создать массив 14x14, заполнить 0
        int[][] fieldZero= new int[field.length+5][field.length+5];
        Arrays.stream(fieldZero).flatMapToInt(Arrays::stream).forEach(x->x=0);

        //вписать массив поля в новый массив, по границам должно получиться 0 0
        for (int j=2;j<12; j++){
            for (int i=2; i<12; i++){
                fieldZero[i][j]=field[i-2][j-2];
            }
        }
        //поиск кораблей
        for (int j=1;j<12; j++){
            for (int i=1; i<12; i++){
                if (fieldZero[i][j]==1){
                    int sum=checkSum(fieldZero,i,j);
                    if (sum==1) oneShipCount++;
                    if (sum==2 && 0==fieldZero[i-1][j+1]+fieldZero[i+1][j+1]+fieldZero[i-1][j-1]+fieldZero[i+1][j-1]) twoShipCount++;
                    if (sum==3 && 0==fieldZero[i-1][j+1]+fieldZero[i+1][j+1]+fieldZero[i-1][j-1]+fieldZero[i+1][j-1]) threeShipCount++;
                    if (sum==4 && 0==fieldZero[i-1][j+1]+fieldZero[i+1][j+1]+fieldZero[i-1][j-1]+fieldZero[i+1][j-1]) fourShipCount++;
                }
            }
        }


        if (oneShipCount==4 && twoShipCount==3 && threeShipCount==2 && fourShipCount==1) return true;


        return false;
    }
}

