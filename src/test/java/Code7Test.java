import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code7Test {

    @DataProvider
    public Object[][]unitTest_Int (){
        return new Object[][]{
                {1000, -2000, 1000},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE},
                {0, 0, 0},
                {0, 2000, 2000},};
    }

    @Test(dataProvider = "unitTest_Int")
    public void code7UnitTestInt (int first, int second, long result) {
        Assert.assertEquals(Code7.max(first, second), result, "Юнит тест не пройден");
    }


}
