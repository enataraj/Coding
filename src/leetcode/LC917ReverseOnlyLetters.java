package leetcode;

public class LC917ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int i = 0, j = charArray.length - 1;

        while (i < j) {
            char ch1 = charArray[i];

            while (i < j && (!((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z')))) {
                i++;
                ch1 = charArray[i];
            }
            char ch2 = charArray[j];
            while (i < j && !((ch2 >= 'a' && ch2 <= 'z') || (ch2 >= 'A' && ch2 <= 'Z'))) {
                j--;
                ch2 = charArray[j];
            }
            charArray[i] = ch2;
            charArray[j] = ch1;
            i++;
            j--;

        }

        return new String(charArray);

    }
    
    public String reverseOnlyLettersSol(String S) {
        char[] resArr = S.toCharArray();
        for(int i=0,j=S.length()-1;i<j;i++,j--){
            while(i<j && !Character.isLetter(resArr[i])) {i++;}
            while(i<j && !Character.isLetter(resArr[j])) {j--;}     
            char temp = resArr[i];
            resArr[i] = resArr[j];
            resArr[j] = temp;
        }
        return new String(resArr);
    }

    public static void main(String[] args) {
        LC917ReverseOnlyLetters obj = new LC917ReverseOnlyLetters();
        String S = "ab-cd";
        System.out.println(obj.reverseOnlyLetters(S));
    }

}
