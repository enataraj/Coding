package leetcode.may;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC943FindShortestSuperString {

    public String shortestSuperstring(String[] words) {

        HashMap<String, String> dp = new LinkedHashMap<>();
        // Using this mask to determine we have consumed this word in idx 
        int mask = 0;
        for (int i = 0; i < words.length; i++)
            mask = mask | (1 << i); // Initially set all of them are available to consume. 1 means available , 0 means consumed. this mask is interger representation of binary we consumed the specific workd or not.
        return helper(dp, mask, words, "");

    }

    public String helper(HashMap<String, String> dp, int mask, String[] words, String start) {

        if (mask == 0)
            return start; // base case

        String key = start + "#" + mask;
        if (dp.get(key) != null)
            return dp.get(key); // memoization 

        String result = null; // result for current subproblem 

        for (int i = 0; i < words.length; i++) {

            if (((mask >> i) & 1) == 1) { // if current spot is available , bit on denotes spot available bit off denotes spot unavailable
                int nmask = mask & ~(1 << i); // turn off the bit corresponding to this word 
                String ros = helper(dp, nmask, words, words[i]); // get shortest superstring starting with words[i]
                String pans = append(start, ros); // kind of a blackbox which generates possible superstring
                if (result == null || pans.length() < result.length())
                    result = pans;
            }

        }

        dp.put(key, result);
        System.out.println(dp);
        return result;
    }

    /*
     * Merge two string a and b if first String Suffix is matched with second String Prefix.
     */
    public String append(String a, String b) {
        for (int i = Math.max(1, a.length() - b.length()); i < a.length(); i++) {
            boolean check = true;
            for (int j = i; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j - i))
                    check = false;
            }
            if (check)
                return a.substring(0, i) + b;
        }
        return a + b;

    }

    public static void main(String[] args) {
        LC943FindShortestSuperString obj = new LC943FindShortestSuperString();
        String[] words = { "catg", "ctaagt", "gcta", "ttca", "atgcatc" };
        System.out.println(obj.shortestSuperstring(words));
    }

}
