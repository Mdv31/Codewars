import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code4Test {
    @DataProvider
    public Object[][]unitTest (){
        return new Object[][]{
                {new int[]{5,6,11,9,7,12,18}, 11},
                {new int[]{5,8,Integer.MIN_VALUE,0,Integer.MAX_VALUE,12,18}, 12},
                {new int[]{5,6,11,5,10,12,18}, 10}
        };
    }

    @Test(dataProvider = "unitTest")
    public void code4UnitTest (int[] inArray,int result) {
        Assert.assertEquals(Code4.digits(inArray), result, "Юнит тест не пройден");
    }
}
