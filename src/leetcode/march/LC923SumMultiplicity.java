package leetcode.march;

import java.util.HashMap;
import java.util.Map;

public class LC923SumMultiplicity {

    public int threeSumMulti(int[] arr, int target) {
        // Build a frequencey Map
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : arr) {
            int freq = frequency.getOrDefault(i, 0);
            frequency.put(i, freq + 1);
        }

        long result = 0;
        for (Integer x : frequency.keySet()) {
            for (Integer y : frequency.keySet()) {
                int z = target - x - y;
                if (frequency.containsKey(z)) {
                    long xfreq = frequency.get(x);
                    long yfreq = frequency.get(y);
                    long zfreq = frequency.get(z);

                    if (x == y && x == z) {
                        result += ((xfreq) * (xfreq - 1) * (xfreq - 2)) / 6; // Nc3
                    } else if (x == y && x != z) { // Two Numbers are same and third one is diff Nc2*Nc1
                        result += ((xfreq) * (xfreq - 1)) / 2 * zfreq;
                    } else if (x < y && y < z) {  // All of them are different Nc1*Nc1*Nc1
                        result += ((xfreq * yfreq * zfreq));
                    }

                }
                
            }
        }
        return (int) (result % 1000000007);
    }

    public int threeSumMultiTLE(int[] arr, int target) {

        int sum = 0;
        int length = arr.length;
        long result = 0;
        for (int i = 0; i < length - 2; i++) {
            sum = arr[i];
            if (sum <= target) {
                for (int j = i + 1; j < length - 1; j++) {
                    sum = arr[i] + arr[j];
                    if (sum <= target) {
                        for (int k = j + 1; k < length; k++) {
                            if (sum + arr[k] == target) {
                                //   System.out.println(arr[i] + " " + arr[j] + "  " + arr[k]);
                                result += 1;
                            }
                        }
                    }
                }
            }
        }

        return (int) result % 1000000007;

    }

    public static void main(String[] args) {
        LC923SumMultiplicity obj = new LC923SumMultiplicity();
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        System.out.println(obj.threeSumMulti(nums, 8));
    }

}
