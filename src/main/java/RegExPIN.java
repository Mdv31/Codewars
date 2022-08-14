/***
 * ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
 *
 * If the function is passed a valid PIN string, return true, else return false.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPIN {

    public static boolean validatePin(String pin) {
        // Your code here...
        String regex = "[0-9]{4}([0-9]{2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pin);
        return matcher.matches();
    }

}