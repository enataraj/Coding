package leetcode.dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC131PalindromicPartition {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        dfsHelpher(s, new ArrayList<String>());
        return result;

    }

    private boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private void dfsHelpher(String s, List<String> curList) {
        if (s.isEmpty()) {
            result.add(curList);

        }

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (isPalindrome(left)) {

                List<String> tmpList = new ArrayList<>(curList);
                tmpList.add(left);
                dfsHelpher(right, tmpList);

            }

        }
    }

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition1(String s) {
        dfs(s, 0, new ArrayList<>());
        return list;
    }

    private void dfs(String s, int start, List<String> curL) {
        if (start >= s.length())
            list.add(new ArrayList<>(curL));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curL.add(s.substring(start, end + 1));
                dfs(s, end + 1, curL);
                curL.remove(curL.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public List<List<String>> partition_Parin(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                char ch1 = s.charAt(i), ch2 = s.charAt(j);

                if (ch1 == ch2) {
                    isPalindrome[i][j] = (len == 2 || isPalindrome[i + 1][j - 1]);
                }
            }
        }

        return helper(s, isPalindrome, 0);
    }

    private List<List<String>> helper(String s, boolean[][] isPalindrome, int idx) {
        List<List<String>> res = new ArrayList<>();
        if (idx == s.length()) {
            res.add(Collections.emptyList());
            return res;
        }

        for (int i = idx; i < s.length(); i++) { // i = 0
            if (isPalindrome[idx][i]) {
                for (List<String> nextPartitions : helper(s, isPalindrome, i + 1)) {
                    List<String> partitions = new ArrayList<>();
                    partitions.add(s.substring(idx, i + 1));
                    partitions.addAll(nextPartitions);
                    res.add(partitions);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC131PalindromicPartition obj = new LC131PalindromicPartition();
        String s = "aaabc";
        System.out.println(obj.partition(s));
        // System.out.println(obj.isPalindrome(s));

    }

}
