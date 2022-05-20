import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code3Test {
    @DataProvider
    public Object[][]unitTest (){
        return new Object[][]{
                {new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}, 19},
                {new int[][]{{1, 2}, {6, 10}, {11, 15}}, 9},
                {new int[][]{{1, 4}, {7, 10}, {3, 5}}, 7}
        };
    }

    @Test(dataProvider = "unitTest")
    public void code3UnitTest (int[][] inArray,int resultText) {
        Assert.assertEquals(Code3.sumIntervals(inArray), resultText, "Юнит тест не пройден");
    }
}
