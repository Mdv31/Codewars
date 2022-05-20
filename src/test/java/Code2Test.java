import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code2Test {
    @DataProvider
    public Object[][]unitTest (){
        return new Object[][]{
                {"16",7},
                {"942",6},
                {"132189",6},
                {"493193",2}};
    }

    @Test(dataProvider = "unitTest")
    public void code2UnitTest (String inText,int resultText) {
        Assert.assertEquals(Code2.sumOfDigits(inText), resultText, "Юнит тест не пройден");
    }
}
