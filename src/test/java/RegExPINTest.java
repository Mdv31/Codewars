import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RegExPINTest {
    @Test
    public void validPins() {
        assertEquals(true, RegExPIN.validatePin("1234"));
        assertEquals(true, RegExPIN.validatePin("0000"));
        assertEquals(true, RegExPIN.validatePin("1111"));
        assertEquals(true, RegExPIN.validatePin("123456"));
        assertEquals(true, RegExPIN.validatePin("098765"));
        assertEquals(true, RegExPIN.validatePin("000000"));
        assertEquals(true, RegExPIN.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, RegExPIN.validatePin("a234"));
        assertEquals(false, RegExPIN.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, RegExPIN.validatePin("1"));
        assertEquals(false, RegExPIN.validatePin("12"));
        assertEquals(false, RegExPIN.validatePin("123"));
        assertEquals(false, RegExPIN.validatePin("12345"));
        assertEquals(false, RegExPIN.validatePin("1234567"));
        assertEquals(false, RegExPIN.validatePin("-1234"));
        assertEquals(false, RegExPIN.validatePin("1.234"));
        assertEquals(false, RegExPIN.validatePin("00000000"));
    }
}