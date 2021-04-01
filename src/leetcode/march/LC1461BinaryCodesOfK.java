package leetcode.march;

import java.util.HashSet;
import java.util.Set;

public class LC1461BinaryCodesOfK {

    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        Set<String> subStringSet = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            subStringSet.add(s.substring(i - k, i));
        }
        return subStringSet.size() == Math.pow(2, k);
    }

    public boolean hasAllCodesSol(String s, int k) {

        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');

            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean hasAllCodesSol2(String s, int k) {
        
        int toFind = 1<<k;
        int mask = toFind - 1;
        int l = s.length();
        byte[] set = new byte[toFind];
        int hash = 0;
        
        for(int i = 0; i < l; i++) {
            
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');
             
            if( i >= k - 1 && set[hash] == 0) {
                set[hash] = 1;
                if(--toFind == 0) {
                    return true;
                }
            }
            
        }
        
        return false;
    
    }

    public boolean hasAllCodesParin(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        int num = 0;
        for (int i = 0; i < k; i++) {
            int digit = s.charAt(i) - '0';
            num = (num * 2) + digit;
        }

        set.add(num);
        for (int i = k; i < s.length(); i++) {
            int leftDigit = s.charAt(i - k) - '0', rightDigit = s.charAt(i) - '0';

            if (leftDigit == 1) {
                num -= (1 << (k - 1));
            }

            num <<= 1;
            num += rightDigit;
            set.add(num);

            if (set.size() == (1 << k)) {
                return true;
            }
        }

        return set.size() == (1 << k);
    }

    public static void main(String[] args) {
        LC1461BinaryCodesOfK obj = new LC1461BinaryCodesOfK();

        String str = "Elumalai";

        System.out.println(str.substring(0, 2));
        obj.hasAllCodes("0110", 2);

    }

}
