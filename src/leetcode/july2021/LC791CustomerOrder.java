package leetcode.july2021;

public class LC791CustomerOrder {

    public String customSortString(String order, String str) {

        int[] chFrq = new int[26];
        for (char ch : str.toCharArray()) {
            chFrq[ch - 'a']++;
        }

        StringBuffer buffer = new StringBuffer();
        for (char ch : order.toCharArray()) {
            int cnt = chFrq[ch - 'a'];
            for (int i = 0; i < cnt; i++) {
                buffer.append(ch);
            }
            chFrq[ch - 'a'] = 0;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int cnt = chFrq[ch - 'a'];
            for (int i = 0; i < cnt; i++) {
                buffer.append(ch);
            }

        }
        return buffer.toString();
    }

}
