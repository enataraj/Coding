package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Weekluy {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            list.add(nums[i] - nums[i - 1]);
        }
        Collections.sort(list);
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= k) {

                k = k - list.get(i);
                count++;

            }

        }

        return count;
    }

    public int longestBeautifulSubstring(String word) {
        char[] charr = word.toCharArray();

        int n = charr.length, longestLength = 0;
        int[] longest = new int[n], counts = new int[n];

        Arrays.fill(longest, 1);
        Arrays.fill(counts, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (charr[i] >= charr[j]) {
                    if (longest[i] < longest[j] + 1) {
                        longest[i] = longest[j] + 1;
                        counts[i] = counts[j];

                    } else if (longest[i] == longest[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }

            longestLength = Math.max(longestLength, longest[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (longest[i] == longestLength) {
                ans += counts[i];
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        Weekluy obj = new Weekluy();
        System.out.println(obj.maxFrequency(nums, 5));

    }

}
