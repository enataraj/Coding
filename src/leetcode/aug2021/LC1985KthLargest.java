package leetcode.aug2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1985KthLargest {

    public String kthLargestNumber(String[] nums, int k) {
        k = nums.length - k;
        Arrays.sort(nums, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                int i = 0;
                if (a.length() == b.length()) {
                    for (i = 0; i < a.length(); i++) {
                        if (i < b.length() && a.charAt(i) != b.charAt(i)) {
                            return a.charAt(i) - b.charAt(i);
                        }
                    }
                }
                return a.length() - b.length();
            }
        });
        System.out.println(Arrays.toString(nums));
        return nums[k];
    }

    public String kthLargestNumberSol(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return a.length() - b.length();
                return a.compareTo(b);
            }
        });
        return nums[nums.length - k];
    }

    class Solution {
        public String kthLargestNumber(String[] nums, int k) {
            PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> {
                if (o1.length() == o2.length()) { // If the same length then compare by their string
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1.length(), o2.length()); // Compare by their length
            });
            for (String num : nums) {
                minHeap.offer(num);
                if (minHeap.size() > k) {
                    minHeap.poll(); // pop the minimum value in the heap
                }
            }
            return minHeap.poll();
        }
    }

    public static void main(String[] args) {
        String[] nums = { "3", "6", "7", "10" };
        LC1985KthLargest obj = new LC1985KthLargest();
        System.out.println(obj.kthLargestNumber(nums, 4));
    }

}
