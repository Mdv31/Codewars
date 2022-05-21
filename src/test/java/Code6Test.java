import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code6Test {
    @DataProvider
    public Object[][]unitTest_String (){
        return new Object[][]{
                {"First","Second", "SecondFirst"}};
    }

    @DataProvider
    public Object[][]unitTest_Int (){
        return new Object[][]{
                {1000,2000, "20001000"}};
    }

    @Test(dataProvider = "unitTest_String")
    public void code6UnitTestString (String first, String second, String result) {
        Assert.assertEquals(Code6.swap(first, second), result, "Юнит тест не пройден");
    }

    @Test(dataProvider = "unitTest_Int")
    public void code6UnitTestInt (int first, int second, String result) {
        Assert.assertEquals(Code6.swap(first, second), result, "Юнит тест не пройден");
    }


}
