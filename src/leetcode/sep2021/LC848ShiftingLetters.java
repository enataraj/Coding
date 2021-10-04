package leetcode.sep2021;

public class LC848ShiftingLetters {

    public String shiftingLettersNotOptimized(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (((charArray[i] - 'a' + shifts[i]) % 26) + 'a');
        }
        return new String(charArray);

    }

    public String shiftingLetters(String s, int[] shifts) {               
        char[] charArray = s.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
            charArray[i+1] = (char) (((charArray[i+1] - 'a' + shifts[i+1]) % 26) + 'a');
        }
        charArray[0] = (char) (((charArray[0] - 'a' + shifts[0]) % 26) + 'a');
        return new String(charArray);  
    }
    
    public String shiftingLettersSol(String s, int[] shifts) {
        int n = shifts.length;
        for (int i = n-2; i >= 0; i--)
            shifts[i] += shifts[i+1]%26;
        
        char[] ret = new char[n];
        for (int i = 0; i < n; i++)
            ret[i] = (char) ((s.charAt(i)-'a'+shifts[i])%26+'a');
        
        return new String(ret);
    }
    public static void main(String[] args) {
        LC848ShiftingLetters obj = new LC848ShiftingLetters();
        String s = "ruu";
        int[] shifts = { 26, 9, 17 };
        System.out.println(obj.shiftingLetters(s, shifts));
    }

}
