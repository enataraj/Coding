package leetcode.march;

import java.util.ArrayList;
import java.util.List;

public class LC916WordSet {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bfreqMap = new int[26];
        // Find Max Fre of Each char in Word B 
        for (String str : B) {
            int[] tmpFrqMap = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                tmpFrqMap[idx]++;
                bfreqMap[idx] = Math.max(bfreqMap[idx], tmpFrqMap[idx]);
            }
        }
        List<String> result = new ArrayList<>();
        int[] afreqMap;
        // Find the fre of Each char from Word A and if its greater or equal add into result. 
        for (String str : A) {
            afreqMap = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                afreqMap[idx]++;
            }

            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (afreqMap[i] < bfreqMap[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(str);
            }
        }
        return result;

    }

    public List<String> wordSubsetsSol(String[] A, String[] B) {
        int count[] = new int[26];
        for (int i = 0; i < B.length; i++) {
            int curr[] = new int[26];
            for (char ch : B[i].toCharArray()) {
                curr[ch - 'a'] += 1;
                count[ch - 'a'] = Math.max(curr[ch - 'a'], count[ch - 'a']);
            }
        }

        List<String> res = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            int curr[] = new int[26];
            boolean flag = true;
            for (char ch : A[i].toCharArray()) {
                curr[ch - 'a'] += 1;
            }

            for (int j = 0; j < 26; j++) {
                if (count[j] > curr[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                res.add(A[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LC916WordSet obj = new LC916WordSet();
        String[] A = { "amazon", "apple", "facebbbbook", "google", "leetcode" };
        String[] B = { "bbb", "oo" };
        System.out.println(obj.wordSubsets(A, B));
    }
}
