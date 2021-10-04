package leetcode.sep2021;

public class LC917ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] chArray = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while (left < right && !Character.isAlphabetic(chArray[left])) {
                left++;
            }

            while (left < right && !Character.isAlphabetic(chArray[right])) {
                right--;
            }

            char tmp = chArray[left];
            chArray[left] = chArray[right];
            chArray[right] = tmp;
            left++;
            right--;

        }
        return new String(chArray);
    }
     
    public static void main(String[] args) {
        LC917ReverseOnlyLetters obj = new LC917ReverseOnlyLetters();
        String s = "ab1cd";
        System.out.println(obj.reverseOnlyLetters(s));
    }

}
