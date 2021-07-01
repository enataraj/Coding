package leetcode.june;

import java.util.LinkedList;
import java.util.Queue;

public class LC1004MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (num == 0) {
                if (cnt == k) {
                    result = Math.max(result, queue.size());
                    while (!queue.isEmpty() && queue.peek() != 0) {
                        queue.poll();
                    }
                    if (!queue.isEmpty()) {
                        queue.poll();
                        queue.add(num);
                    }

                } else {
                    queue.add(num);
                    cnt++;
                }

            } else {
                queue.add(num);
            }
        }

        result = Math.max(queue.size(), result);
        return result;

    }

    public int longestOnesSol(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0)
                K--;
            if (K < 0 && A[i++] == 0)
                K++;
        }
        return j - i;
    }
    
    public int longestOnesSol2(int[] nums, int k) {
        int startIndex = 0, zerosCount = 0, answer = 0;
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            zerosCount += (nums[endIndex] ^ 1);
            while (zerosCount > k)
                zerosCount -= (nums[startIndex++] ^ 1);
            answer = Math.max(answer, endIndex - startIndex + 1);
        }
        return answer;
    }
    

    public static void main(String[] args) {
        LC1004MaxConsecutiveOnes obj = new LC1004MaxConsecutiveOnes();

    }

}
