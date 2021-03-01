package leetcode.string;

public class LC557ReverseWordsIII {

    public String reverseWords(String s) {
        if (s == null)
            return s;
        StringBuffer result = new StringBuffer();
        for (String str : s.split(" ")) {

            result.append(reverseString(str));
        }
        return result.toString().trim();
    }

    private String reverseString(String str) {
        int i = 0, j = str.length() - 1;
        char[] charArray = str.toCharArray();
        while (i < j) {
            char ch = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = ch;
            i++;
            j--;

        }
        return new String(charArray)+" ";

    }
    
    
    public String reverseWordsSol(String s) {
        char[] charArray = s.toCharArray();
        reverse(charArray, 0);
        return String.valueOf(charArray);
    }
    
    private void reverse(char[] arr, int index) {
        int left = index;
        while (index < arr.length && arr[index] != ' ') {
            index++;
        }
        int right = index - 1;
        
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        
        if (index < arr.length - 1) {
            reverse(arr, index + 1);
        }
    }

    public static void main(String[] args) {
        LC557ReverseWordsIII obj = new LC557ReverseWordsIII();

    }

}
