package leetcode.weekly;

import java.util.LinkedList;
import java.util.Queue;

class MKAverage {
    Queue<Integer> q = new LinkedList<Integer>();
    int number;
    int m, k;
    long[] sum = new long[100001];
    int[] count = new int[100001];

    public MKAverage(int m, int k) {
        number = 0;
        this.m = m;
        this.k = k;

    }

    public void update(int idx, int delta0, int delta1) {
        idx += 1;
        while (idx < sum.length) {
            sum[idx] += (long) delta0;
            count[idx] += delta1;
            idx = idx + (idx & -idx);
        }
    }

    public void addElement(int num) {
        q.offer(num);
        number++;
        update(num - 1, num, 1);
        if (number > m) {
            number--;
            int t = q.poll();
            update(t - 1, -t, -1);
        }
    }

    public long getSum(int x) {
        int p = 1;
        while ((p << 1) < sum.length)
            p <<= 1;
        int sc = 0;
        int value = 0;
        long sum1 = 0;
        while (p > 0) {
            if (value + p < sum.length && sc + count[value + p] <= x) {
                value += p;
                sc += count[value];
                sum1 += sum[value];
            }
            p >>= 1;
        }
        return sum1 + (long) (value + 1) * (long) (x - sc);
    }

    public int calculateMKAverage() {
        if (number < m) {
            return -1;
        }
        return (int) Math.floor(((double) getSum(m - k) - (double) getSum(k)) / (double) (m - k * 2));
    }
}