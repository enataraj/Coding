package leetcode.sep2021;

public class LC1328BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] charArray = palindrome.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 'a' && !isPalindrome(charArray, i)) {
                return new String(charArray);
            }
        }
        charArray[charArray.length - 1] = 'b';
        return new String(charArray);
    }

    private boolean isPalindrome(char[] charArray, int idx) {
        int left = 0;
        int right = charArray.length-1;
        char tmp = charArray[idx];
        charArray[idx] = 'a';
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        charArray[idx] = tmp;
        return true;
    }
    
    public static void main(String[] args) {
        LC1328BreakPalindrome obj = new LC1328BreakPalindrome();
        String palindrome = "abccba";
        System.out.println(obj.breakPalindrome(palindrome));
    }

}
