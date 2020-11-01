package leetcode.oct;

public class RemoveDuplicates {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] result = new char[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            result[idx] = s.charAt(i);
        }

        StringBuffer resultBuffer = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            if (result[i] != '\0') {
                resultBuffer.append(result[i]);
            }
        }
        return resultBuffer.toString();

    }

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        String str = "cbacdcbc";
        System.out.println(obj.removeDuplicateLetters(str));
    }

}
