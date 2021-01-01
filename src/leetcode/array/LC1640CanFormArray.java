package leetcode.array;

import java.util.Arrays;

public class LC1640CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        String tStr = arr.toString();
        tStr = tStr.substring(1,tStr.length());

        StringBuffer strBuffer = new StringBuffer(tStr);
        
        for (int i = 0; i < pieces.length; i++) {
            StringBuffer tmpBuffer = new StringBuffer(Arrays.toString(pieces[i]));
            
            System.out.println("Str Buffer : " + strBuffer);
            System.out.println("tmp buffer " + tmpBuffer);
            int idx = strBuffer.indexOf(tmpBuffer.toString());
            if (idx == -1) {
                return false;
            }
            String str = strBuffer.substring(idx, idx + tmpBuffer.length());
            if (str.equals(tmpBuffer.toString())) {
                strBuffer.replace(idx, idx + tmpBuffer.length(), "");
            }
        }

        // System.out.println(strBuffer);
        if (strBuffer.length() == 0) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        LC1640CanFormArray obj = new LC1640CanFormArray();
        // int[] arr = { 91, 4, 64, 78 };
        // int[][] pieces = { { 78 }, { 4, 64 }, { 91 } };
        // int[] arr = { 12 };
        // int[][] pieces = { { 1 } };
        int[] arr = { 1, 2, 3 };
        int[][] pieces = { { 2 }, { 1, 3 } };

        System.out.println(obj.canFormArray(arr, pieces));

    }

}
