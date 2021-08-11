package leetcode.weekly.week252;

public class PrefixString {

    public boolean isPrefixString(String s, String[] words) {
        StringBuffer buffer = new StringBuffer();
        for (String word : words) {
            if (s.length() > buffer.length()) {
                buffer.append(word);
            }
        }
        return buffer.toString().equals(s);
    }

}
