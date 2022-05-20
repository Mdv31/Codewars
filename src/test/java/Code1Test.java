import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Code1Test {
    @DataProvider
    public Object[][]unitTest (){
        return new Object[][]{
                {"Hey fellow warriors","Hey wollef sroirraw"},
                {"This is a test","This is a test"},
                {"This is another test","This is rehtona test"}};
    }

    @Test(dataProvider = "unitTest")
    public void code1UnitTest (String inText,String resultText) {
        Assert.assertEquals(Code1.mySdrow(inText), resultText, "Юнит тест не пройден");
    }
}
