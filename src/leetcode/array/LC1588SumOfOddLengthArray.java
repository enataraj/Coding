package leetcode.array;

import java.util.Arrays;

public class LC1588SumOfOddLengthArray {
    // https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/981968/Java-easy-solution-with-proper-explanation.

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int runningSum[] = new int[arr.length];
        runningSum[0] = arr[0];
        sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            runningSum[i] = arr[i] +runningSum[i - 1];
            sum += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(runningSum));
        
        System.out.println(sum);
        
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0) {
                sum += runningSum[i];
            }
            
        }
        return sum;
    }

    public int sumOddLengthSubarraysSol(int[] arr) {
        int result = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int end = i + 1;
            int start = n - i;
            int total = start * end;
            int odd = total / 2;
            System.out.println("Start : "+start);
            System.out.println("end : "+end);
            System.out.println("odd : "+odd);
            System.out.println("total : "+total);
            
            if (total % 2 == 1) {
                odd++;
            }
            result += odd * arr[i];
        }
        return result;

    }

    public int sumOddLengthSubarraysNW(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int res = arr[0];
        int preFixSumArray[] = new int[arr.length];
        preFixSumArray[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            preFixSumArray[i] = preFixSumArray[i - 1] + arr[i];
            res += arr[i];

            for (int j = 2; j <= i; j += 2) {
                if (j >= 2) {
                    if (j == i) {
                        res += preFixSumArray[i];
                    } else {
                        res += preFixSumArray[i] - preFixSumArray[i - j + 1];
                    }
                }

                /*
                 * if (i >= 2) { if (i == 2) { res += preFixSumArray[i]; } else { res +=
                 * preFixSumArray[i] - preFixSumArray[i - 3]; } } if (i >= 4) { if (i == 4) {
                 * res += preFixSumArray[i]; } else { res += preFixSumArray[i] -
                 * preFixSumArray[i - 5]; } } if (i >= 6) { if (i == 6) { res +=
                 * preFixSumArray[i]; } else { res += preFixSumArray[i] - preFixSumArray[i - 7];
                 * } }
                 */
            }
        }

        System.out.println(Arrays.toString(preFixSumArray));
        return res;

    }

    public static void main(String[] args) {
        LC1588SumOfOddLengthArray obj = new LC1588SumOfOddLengthArray();
        int[] arr = { 1, 4, 2, 5, 3 };
       // System.out.println(obj.sumOddLengthSubarrays(arr));
        System.out.println(obj.sumOddLengthSubarraysSol(arr));

    }

}
