package leetcode.june;

import java.util.Arrays;

public class LC1465MaxCut {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxGapVertical = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        long maxGapHorizantal = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxGapHorizantal = Math.max(maxGapHorizantal, (horizontalCuts[i] - horizontalCuts[i - 1]));

        }

        for (int i = 1; i < verticalCuts.length; i++) {
            maxGapVertical = Math.max(maxGapVertical, (verticalCuts[i] - verticalCuts[i - 1]));

        }

        return (int) ((maxGapHorizantal * maxGapVertical) % 1000000007);

    }

    public static void main(String[] args) {
        LC1465MaxCut obj = new LC1465MaxCut();

        int h = 5;
        int w = 4;
        int[] horizontalCuts = { 1 };
        int[] verticalCuts = { 3, 1 };
        System.out.println(obj.maxArea(h, w, horizontalCuts, verticalCuts));

    }

}
