package leetcode.dec;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC880DecodeStringAtIndex {
    
    
    /*
    If we have a decoded string like appleappleappleappleappleapple and an index like K = 24, the answer is the same if K = 4.
    In general, when a decoded string is equal to some word with size length repeated some number of times (such as apple with size = 5           repeated 6 times), the answer is the same for the index K as it is for the index K % size
*/
public String decodeAtIndex(String S, int K) {
    // Size of the decoded string 
    long size = 0;
    
    // length of the string 
    int N = S.length();

    // Calculate the length of the decoded string
    for (int i = 0; i < N; ++i) {
        // Get the character at the ith position 
        char c = S.charAt(i);
        
        // If it is a digit then multiply previous size by the digit
        if (Character.isDigit(c))
            size *= c - '0';
        else
            size++;
    }

    // Start traversing from the right
    for (int i = N-1; i >= 0; --i) {
        // If the 
        char c = S.charAt(i);
       
        K %= size;
        if (K == 0 && Character.isLetter(c))
            return Character.toString(c);

        if (Character.isDigit(c)) {
            size /= c - '0';
             
        }
        else {
            size--;
        }
    }

    throw null;
}

    public String decodeAtIndexNW2(String S, int K) {

        K = K - 1;
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        StringBuffer strBuffer = new StringBuffer();
        StringBuffer digitBuffer = new StringBuffer();
        boolean digitCollected = false;
        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (digitCollected) {
                    freqMap.put(strBuffer.toString(), Integer.parseInt(digitBuffer.toString()));
                    strBuffer = new StringBuffer();
                    digitBuffer = new StringBuffer();
                    digitCollected = false;

                }
                strBuffer.append(ch);
            } else if (ch >= '2' && ch <= '9') {
                digitBuffer.append(ch);
                digitCollected = true;
            }

        }

        if (strBuffer.length() != 0) {
            if (digitBuffer.length() != 0) {
                freqMap.put(strBuffer.toString(), Integer.parseInt(digitBuffer.toString()));
            } else {
                freqMap.put(strBuffer.toString(), 1);
            }
        }
        System.out.println(freqMap);

        return "";

    }

    public String decodeAtIndexNW(String S, int K) {

        K = K - 1;

        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                strBuffer.append(ch);
            } else if (ch >= '2' && ch <= '9') {
                int times = ch - 48;
                StringBuffer oldBuffer = strBuffer;
                strBuffer = new StringBuffer();
                for (int j = 0; j < times; j++) {
                    strBuffer.append(oldBuffer);

                }

            }

            // System.out.println(strBuffer);
            if (strBuffer.length() > K) {
                return "" + strBuffer.charAt(K);
            }
        }
        return "";

    }

    public static void main(String[] args) {
        LC880DecodeStringAtIndex obj = new LC880DecodeStringAtIndex();
        // String S = "abc";
        // int K = 3;

        // String S = "a2b3c4d5e6f7g8h9";
        // int K= 10;
        // String S = "leet2code3";
        // int K=10;

        String S = "vzpp636m8y";
        int K = 2920;

        System.out.println(obj.decodeAtIndex(S, K));
        
        /*
         * (959+1)*(969)+1
         * 
         * (4*2+4)*3
         * 
         */

    }

}
