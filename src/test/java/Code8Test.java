import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code8Test {

    @DataProvider
    public Object[][]unitTest (){
        return new Object[][]{
                {"123qwe", " 123qwe", false},
                {"", "", true},
                {"asdfghjkl   ", "fgh asd jkl ", true}};
    }

    @Test(dataProvider = "unitTest")
    public void code8UnitTestInt (String first, String second, boolean result) {
        Assert.assertEquals(Code8.equalSwap(first, second), result, "Юнит тест не пройден");
    }


}
