package leetcode.nov;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMax {

    public int[] maxSlidingWindowNW(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (deque.size() < k) {
                max = Math.max(max, nums[i]);
                deque.add(nums[i]);
                if (deque.size() == k) {
                    res[idx] = max;
                    idx++;
                }
            }
        }

        for (int i = k; i < nums.length; i++) {
            int tmp = deque.pollFirst();
            int curNum = nums[i];
            deque.add(curNum);
            if (tmp < max) {
                if (curNum >= max) {
                    max = curNum;
                }

            } else {
                if (curNum >= max) {
                    max = curNum;
                } else {
                    int tmpMax = Integer.MIN_VALUE;
                    for (int z : deque) {
                        tmpMax = Math.max(tmpMax, z);

                    }
                    max = tmpMax;
                }
            }
            res[idx] = max;
            idx++;
        }

        return res;

    }

    private class Data {
        int value;
        int idx;

        public Data(int value, int idx) {
            this.value = value;
            this.idx = idx;

        }

        @Override
        public String toString() {
            return "idx  : " + idx + " Value " + value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Data> deque = new LinkedList<>();

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            while (!deque.isEmpty() && deque.peekLast().value < n) {
                deque.pollLast();
            }

            deque.add(new Data(n, i));

            if (i >= k) {
                while (!deque.isEmpty() && deque.peekFirst().idx <= i - k)
                    deque.pollFirst();
            }
            if (i >= k - 1) {
                res[idx] = deque.peekFirst().value;
                idx++;

            }
            System.out.println(deque);
        }

        return res;

    }

    public int[] maxSlidingWindowDP(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k || k == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i = i + k) {
            int end = i + k - 1 < len ? i + k - 1 : len - 1;
            max = nums[i];
            leftmax[i] = max;
            for (int j = i + 1; j <= end; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                leftmax[j] = max;
            }

            max = nums[end];
            rightmax[end] = max;
            for (int j = end - 1; j >= i; j--) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                rightmax[j] = max;
            }
        }

        int[] res = new int[len - k + 1];
        for (int start = 0; start < len - k + 1; start++) {
            int end = start + k - 1;
            res[start] = Math.max(rightmax[start], leftmax[end]);
        }
        return res;
    }

    public int[] maxSlidingWindowDP2(int[] nums, int k) {
        int len = nums.length;
        int resultLength = len - k + 1;

        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len; i += k) {
            int max = nums[i];
            int lastIndex = (i + k - 1 >= len) ? (len - 1) : (i + k - 1);

            // calculate max num in blocks of k from left -> right
            // (every block will be of k size except last one)
            for (int j = i; j <= lastIndex; j++) {
                max = Math.max(max, nums[j]);
                left[j] = max;
            }

            // calculate max num in blocks of k from right -> left
            // (every block will be of k size except last one)
            max = nums[lastIndex];
            for (int j = lastIndex; j >= i; j--) {
                max = Math.max(max, nums[j]);
                right[j] = max;
            }
        }

        int[] result = new int[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = Math.max(left[i + k - 1], right[i]);
        }
        return result;
    }

    private class QueueWithMax {
        Deque<Integer> dq;
        Queue<Integer> q;

        QueueWithMax() {
            dq = new ArrayDeque<>();
            q = new LinkedList<>();
        }

        void add(int num) {
            while (!dq.isEmpty() && num > dq.peekLast()) {
                dq.pollLast();
            }

            dq.addLast(num);
            q.add(num);
        }

        int poll() {
            int res = q.poll();

            if (dq.peekFirst() == res) {
                dq.pollFirst();
            }

            return res;
        }

        int getMax() {
            return dq.peekFirst();
        }
    }

    public int[] maxSlidingWindow_Parin(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        QueueWithMax qMax = new QueueWithMax();
        int i = 0;

        while (i < k) {
            qMax.add(nums[i]);
            ++i;
        }

        int writeIdx = 0;
        res[writeIdx++] = qMax.getMax();

        for (; i < n; i++) {
            qMax.poll();
            qMax.add(nums[i]);
            res[writeIdx++] = qMax.getMax();
        }

        return res;
    }

    public static void main(String[] args) {

        SlidingWindowMax obj = new SlidingWindowMax();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(nums));
        System.out.println("result expected :  3,3,5,5,6,7");
        int[] res = obj.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

    }

}
