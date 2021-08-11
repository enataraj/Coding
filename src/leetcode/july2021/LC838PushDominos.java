package leetcode.july2021;

public class LC838PushDominos {

    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 1; j < dominoes.length(); ++j) {
            if (dominoes.charAt(j) == '.')
                continue;
            int mid = j - i - 1;
            if (i > 0)
                res.append(dominoes.charAt(i));
            if (dominoes.charAt(i) == dominoes.charAt(j))
                for (int k = 0; k < mid; k++)
                    res.append(dominoes.charAt(i));
            else if (dominoes.charAt(i) == 'L' && dominoes.charAt(j) == 'R')
                for (int k = 0; k < mid; k++)
                    res.append('.');
            else {
                for (int k = 0; k < mid / 2; k++)
                    res.append('R');
                if (mid % 2 == 1)
                    res.append('.');
                for (int k = 0; k < mid / 2; k++)
                    res.append('L');
            }
            i = j;
        }
        return res.toString();
    }

    class Solution {
        public String pushDominoes(String dominoes) {
            if (dominoes.length() == 0) {
                return dominoes;
            }

            int n = dominoes.length();
            char[] dos = new char[n + 2];
            System.arraycopy(dominoes.toCharArray(), 0, dos, 1, n);
            dos[0] = 'L';
            dos[n + 1] = 'R';

            int start = 0;
            char sdir;
            while (start <= n) {
                sdir = dos[start];
                int end = start + 1;
                while (dos[end] == '.') {
                    end++;
                }
                char edir = dos[end];

                if (edir == 'R') {
                    if (sdir == 'R') {
                        // falling right
                        for (; start < end; start++) {
                            dos[start] = 'R';
                        }
                    } else { // sdir == 'L'
                        // do nothing
                        start = end;
                    }
                } else { // edir == 'L'
                    if (sdir == 'R') {
                        // falling opposite
                        int i = start, j = end;
                        while (i < j) {
                            dos[i++] = 'R';
                            dos[j--] = 'L';
                        }
                        start = end;
                    } else { // sdir == 'L'
                        // falling left
                        for (; start < end; start++) {
                            dos[start] = 'L';
                        }
                    }
                }
            }
            return String.valueOf(dos).substring(1, n + 1);
        }
    }

}
