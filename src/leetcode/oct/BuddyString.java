package leetcode.oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;

        if (A.equals(B)) {
            Set<Character> set = new HashSet();
            for (char c : A.toCharArray()) {
                if (set.contains(c))
                    return true;
                set.add(c);
            }
            return false;
        }
        List<Integer> index = new ArrayList();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                index.add(i);
            if (index.size() > 2)
                return false;
        }

        return index.size() == 2 && A.charAt(index.get(0)) == B.charAt(index.get(1))
                && A.charAt(index.get(1)) == B.charAt(index.get(0));

    }
    
    /*
     * 
     * 1) Length A and Length B is not equal -> False
     * 
     * 2) A==B and set(A).size < len(A)
     * 
     * 3) for(i 0-> len)
     *    A[i] != B[i]
     *    
     *    diff.append(a[i],b[i])
     *     diff size ==2 and diff[0]==diff[1]
     *     
     *     diff!=2 return false
     *     
     *     
     * 
     * 
     */

    public static void main(String[] args) {
        BuddyString obj = new BuddyString();
        String A = "aaaaaaabc";
        String B = "aaaaaaacb";
        System.out.println(obj.buddyStrings(A, B));

    }

}
