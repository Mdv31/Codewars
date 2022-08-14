import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class nextBiggerNumberTests {
    @Test
    public void basicTests() {
        assertEquals(573207489, nextBiggerNumber.nextBiggerNumber(573204987));
        assertEquals(1129266235, nextBiggerNumber.nextBiggerNumber(1129265632));
        assertEquals(1234567908, nextBiggerNumber.nextBiggerNumber(1234567890));
        assertEquals(21, nextBiggerNumber.nextBiggerNumber(12));
        assertEquals(531, nextBiggerNumber.nextBiggerNumber(513));
        assertEquals(2071, nextBiggerNumber.nextBiggerNumber(2017));
        assertEquals(441, nextBiggerNumber.nextBiggerNumber(414));
        assertEquals(414, nextBiggerNumber.nextBiggerNumber(144));
        assertEquals(19009, nextBiggerNumber.nextBiggerNumber(10990));
    }
}