package leetcode.array;

import java.util.Arrays;

public class LC1742MaxNumberOfBalls {

    public int countBalls(int lowLimit, int highLimit) {
        int[] cache = new int[46];

        for (int i = lowLimit; i <= highLimit; i++) {
            int idx = getIdx(i);
            System.out.println(idx);
            cache[idx]++;

        }

        System.out.println(Arrays.toString(cache));

        int max = 0;
        for (int i = 0; i < 46; i++) {
            max = Math.max(max, cache[i]);
        }

        return max;
    }

    private int getIdx(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public int countBallsSol(int lowLimit, int highLimit) {
        int[] boxes = new int[46]; // Max of 9+9+9+9+9=45 possible digit sums.

        if (highLimit == 100_000) { // Only 100,000 can have a digit in the 10^5 position.
            boxes[1] = 1;
            highLimit = 99_999;
        }

        int low0 = lowLimit % 10; // Initial digit in the 10^0 (one's) position.
        int low1 = (lowLimit / 10) % 10; // Initial digit in the 10^1 (ten's) position.
        int low2 = (lowLimit / 100) % 10; // Initial digit in the 10^2 (hundred's) position.
        int low3 = (lowLimit / 1000) % 10; // Initial digit in the 10^3 (thousand's) position.
        int low4 = (lowLimit / 10000) % 10; // Initial digit in the 10^4 (ten thousand's) position.
        int count = highLimit - lowLimit + 1; // Number of digit-sums to accumulate.
        for (int dig4 = low4; dig4 <= 9; dig4++) { // Loop for 10^4 digit position.
            int sum4 = dig4;
            for (int dig3 = low3; dig3 <= 9; dig3++) { // Loop for 10^3 digit position.
                int sum3 = sum4 + dig3;
                for (int dig2 = low2; dig2 <= 9; dig2++) { // Loop for 10^2 digit position.
                    int sum2 = sum3 + dig2;
                    for (int dig1 = low1; dig1 <= 9; dig1++) { // Loop for 10^1 digit position.
                        int sum1 = sum2 + dig1;
                        for (int dig0 = low0; dig0 <= 9; dig0++) { // Loop for 10^0 (one's) digit position.
                            boxes[sum1 + dig0]++; // Count another ball's digit sum in a box.
                            if (--count == 0)
                                return maxVal(boxes);// If done accumulating sums, then return max value in boxes[].
                        }
                        low0 = 0; // Next time, digit in 10^0 position starts at zero.
                    }
                    low1 = 0; // Next time, digit in 10^1 position starts at zero.
                }
                low2 = 0; // Next time, digit in 10^2 position starts at zero.
            }
            low3 = 0; // Next time, digit in 10^3 position starts at zero.
        }
        return -1; // Should never get here.
    }

    private int maxVal(int[] arr) {
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--)
            max = Math.max(max, arr[i]);
        return max;
    }

    public static void main(String[] args) {
        LC1742MaxNumberOfBalls obj = new LC1742MaxNumberOfBalls();
        int low = 5;
        int high = 15;
        System.out.println(obj.countBalls(low, high));
    }

}
