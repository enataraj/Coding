package leetcode.may;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

public class LC65ValidNumber {

    /*
     * When a Number become Invalid.
     * 
     * 1) If the given string doesnt have any digits , Meaning it has only + ,-,e etc., This is Invalid.
     * 2) How many plus or minus Symbol you can have at max?  Only 2, One could be beginning of the string another one may be after 'e' char. 
     *    Which means when you see the + or - , Either it should beginning of the string or next to char 'e' else the given string is invalid
     *    
     *    Also you cann't have + or - end of the string.
     * 3) when you encounter "." , You should not encounter "." earlier, because valid number should not have more than one "."
     *    "." Should not come after E, If so its invalid.
     *    "." Should not come end of the string
     *    If there is dot at the end and did not see any digit so far, its invalid.
     *    
     * 4) If we encounter "e" , 
     *       1) You should not seen "e" earlier
     *       2) Without encounter any digit if we see "e" also invalid
     *       3) If end of the string we see also invalid.
     *       
     * 5) If we see any other char, its invalid number.
     */

    public boolean isNumber(String s) {
        boolean seenDigits = false;
        int plusOrMinusCnt = 0;
        boolean seenDot = false;
        boolean seenE = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') { // If we see the digits set the flag. Possible test case may not have digit at all.
                seenDigits = true;
            } else if (ch == '-' || ch == '+') { // If we see + or 1, Only max of two char can exist in given string.
                if (plusOrMinusCnt == 2) {
                    return false;
                }
                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) { // If i see + or - not in the beginning , previous char should be 'e' 
                    return false;
                }
                if (i == s.length() - 1) { // If we see the + or - in last position then false
                    return false;
                }
                plusOrMinusCnt++;
            }

            else if (ch == '.') {
                if (seenE || seenDot) { // After e it should not have any dot
                    return false;
                }
                if (i == s.length() - 1 && !seenDigits) { // begining and last char should be '.'
                    return false;
                }

                seenDot = true;
            }

            else if ((ch == 'e' || ch == 'E')) { // if we see 'e' , if already we have seen E then its false.

                if (seenE || !seenDigits || i == s.length() - 1) {
                    return false;
                }
                seenE = true;

            }

            else {
                return false;
            }

        }
        if (!seenDigits) {
            return false;
        }
        return true;
    }

    /*   
    ^                     Start of regular expression
    [+,-]?                Optional sign 
    (\d+(\.\d*)?)         Atleast one digit followed by optional (. followed by 0 or more characters )
    (\.[0-9]+)            This is to handle cases like .3 which is not handled by above expression 
    (e[+,-]?\d+)?         Optional (e followed by an optional sign , followed by one or more numbers)
    
      */
    public boolean validNumberRegEx(String s) {
        
            s = s.trim();
            if(s.equals("")) return false;
            Pattern p = Pattern.compile("^[+,-]?(((\\d+\\.\\d*)|(.\\d+))|\\d+)([eE][+-]?\\d+)?$");
            Matcher m = p.matcher(s);
            return m.matches();
        
        
    }

    public static void main(String[] args) {
        LC65ValidNumber obj = new LC65ValidNumber();
    }

}
