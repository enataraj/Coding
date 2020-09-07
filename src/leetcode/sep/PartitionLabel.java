package leetcode.sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> resultList = new ArrayList<>();

        Map<Character, Integer> indxMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            indxMap.put(S.charAt(i), i);
        }

        int start = 0, end = 0;

        for (int i = 0; i < S.length(); i++) {
            int tmp = indxMap.get(S.charAt(i));
            end = Math.max(end, tmp);
            if (i == end) {
                resultList.add(end + 1 - start);
                start = end + 1;
            }

        }

        return resultList;
    }

    public List<Integer> partitionLabelsOpt(String S) {
        int n = S.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < n; i++)
            count[S.charAt(i) - 'a'] = i;
        int start = 0;
        while (start < n) {
            int end = getlastIndex(count, S, start);
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }

    public int getlastIndex(int[] count, String s, int start) {
        int max = count[s.charAt(start) - 'a'];
        int pos = start;
        while (pos < max) {
            max = Math.max(max, count[s.charAt(pos) - 'a']);
            pos++;
        }
        return max;
    }

    public static void main(String[] args) {

        PartitionLabel obj = new PartitionLabel();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(obj.partitionLabels(S));

    }

}
