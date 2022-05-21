import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code5Test {
    @DataProvider
    public Object[][]unitTest (){
        return new Object[][]{
                {5,"101"},
                {0,"0"},
                {157,"10011101"},
                {Integer.MAX_VALUE,"1111111111111111111111111111111"}};
    }

    @Test(dataProvider = "unitTest")
    public void code5UnitTest (int inNumber,String result) {
        Assert.assertEquals(Code5.tobinary(inNumber), result, "Юнит тест не пройден");
        Assert.assertEquals(Code5.tobinary2(inNumber), result, "Юнит тест не пройден");
    }
}
