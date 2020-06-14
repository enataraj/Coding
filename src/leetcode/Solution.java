package leetcode;

import java.util.Random;

class Solution {

    private int[] sum;
    private Random rand;
    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = w[i] + sum[i - 1];
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        // range needs to be 1~sum, for example, w: 1, 3, sum: 1, 4, 1/4 return 0, 3/4 return 1
        // random range is not 0 ~ 3, it should be 1 ~ 4
        // [min, max] is random.nextInt(max - min + 1) + min, max = 4, min = 1 
        int index = rand.nextInt(sum[sum.length - 1]) + 1;
        int start = 0;
        int end = sum.length - 1;
        System.out.println(index);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] > index) {
                end = mid;
            } else {
                start = mid;
            }
        }
        // 第一个大于随机数x的数字的坐标
        if (sum[start] >= index) {
            return start;
        } else {
            return end;
        }
    }
    
    
    public static void main(String[] args) {
        int[] w = { 3, 5, 7, 2, 4 };
        Solution obj = new Solution(w);
        int param_1 = obj.pickIndex();
        
    }
}



/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

