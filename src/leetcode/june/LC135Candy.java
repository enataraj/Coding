package leetcode.june;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC135Candy {

    /*
     * 1 0 2 2 2
     * 
     * 1 1 1
     * 
     * 
     */

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int length = ratings.length - 1;
        int candy[] = new int[ratings.length];
        Arrays.fill(candy, 1);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i <= length; i++) {
            int data[] = new int[2];
            data[0] = ratings[i];
            data[1] = i;
            queue.add(data);
        }

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int idx = data[1];
            int rating = data[0];
            if (idx == 0 && rating > ratings[idx + 1]) {
                candy[idx] = candy[idx + 1] + 1;
            } else if (idx == length && rating > ratings[idx - 1]) {
                candy[idx] = candy[idx - 1] + 1;
            } else if (idx > 0 && idx < length && rating > ratings[idx - 1] && rating > ratings[idx + 1]) {
                candy[idx] = Math.max(candy[idx - 1], candy[idx + 1]) + 1;
            } else if (idx > 0 && idx < length && rating > ratings[idx - 1]) {
                candy[idx] = candy[idx - 1] + 1;
            } else if (idx > 0 && idx < length && rating > ratings[idx + 1]) {
                candy[idx] = candy[idx + 1] + 1;
            }

        }

        int result = 0;
        for (int num : candy) {
            result += num;
        }
        return result;

    }

    public int candyOpt(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int length = ratings.length - 1;
        int candy[] = new int[ratings.length];
        Arrays.fill(candy, 1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i <= length; i++) {
            int data[] = new int[2];
            data[0] = ratings[i];
            data[1] = i;
            queue.add(data);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int idx = data[1];
            int rating = data[0];
            if (idx == 0 && rating > ratings[idx + 1]) {
                candy[idx] = candy[idx + 1] + 1;
            } else if (idx == length && rating > ratings[idx - 1]) {
                candy[idx] = candy[idx - 1] + 1;
            } else if (idx > 0 && idx < length) {
                if (rating > ratings[idx - 1] && rating > ratings[idx + 1]) {
                    candy[idx] = Math.max(candy[idx - 1], candy[idx + 1]) + 1;
                } else if (idx < length && rating > ratings[idx - 1]) {
                    candy[idx] = candy[idx - 1] + 1;
                } else if (idx < length && rating > ratings[idx + 1]) {
                    candy[idx] = candy[idx + 1] + 1;
                }

            }
            result += candy[idx];
        }

        return result;

    }

    public int candySol1(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int length = ratings.length - 1;
        int candyLeft[] = new int[ratings.length];
        Arrays.fill(candyLeft, 1);

        int candyRight[] = new int[ratings.length];
        Arrays.fill(candyRight, 1);

        for (int i = 1; i <= length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyLeft[i] = candyLeft[i - 1] + 1;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyRight[i] = candyRight[i + 1] + 1;
            }
        }

        int total = 0;
        for (int i = 0; i <= length; i++) {
            total += Math.max(candyLeft[i], candyRight[i]);
        }
        return total;

    }

    public int candySol(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int length = ratings.length - 1;
        int candy[] = new int[ratings.length];
        Arrays.fill(candy, 1);

        for (int i = 1; i <= length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candy[i] <= candy[i + 1]) {
                    candy[i] = candy[i + 1] + 1;
                }
            }
        }
        int result = 0;
        for (int num : candy) {
            result += num;
        }
        return result;

    }

    public static void main(String[] args) {
        LC135Candy obj = new LC135Candy();

    }

}
