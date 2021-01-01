package leetcode.array;

import java.util.Arrays;

public class LC1051HeightChecker {

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int count = 0;
        int[] sortedHieghts = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHieghts);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHieghts[i]) {
                count++;
            }

        }

        return count;

    }
    
    
    public int heightChecker_Sol(int[] heights) {
        int[] heightToFreq = new int[101];
        
        for (int height : heights) {
            heightToFreq[height]++;
        }
        
        int result = 0;
        int curHeight = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }
            
            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }
        
        return result;
    }

    public static void main(String[] args) {
        LC1051HeightChecker obj = new LC1051HeightChecker();

        // int[] heights = { 1, 1, 4, 2, 1, 3 };
        int[] heights = { 5, 1, 2, 3, 4 };
        System.out.println(obj.heightChecker(heights));

    }

}
