package leetcode.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1649CreateSortedArrayInstructions {

    
  

    
    
    public int createSortedArrayTLE3(int[] instructions) {
        int cost = 0;
        int MOD = (int) 1e9 + 7;
        
        List<Integer> numsList = new ArrayList<>();
        numsList.add(instructions[0]);
        for (int i = 1; i < instructions.length; i++) {
            int num = instructions[i];
            if (num <= numsList.get(0)) {
                numsList.add(0, num);
            } else if (num >= numsList.get(numsList.size() - 1)) {
                numsList.add(num);
            } else {
                int min = binSearchMin(numsList, num);
                int max = numsList.size() - binSearchMax(numsList, num);
                cost += Math.min(min, max);
                cost = (int) (cost % MOD);
                numsList.add(min, num);
                
            }
        }
      
        return (int) (cost % MOD);
    }
    
    
    
    public int binSearchMax(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        
        if(r < l) {
            return 0;
        }
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return nums.get(r) <= target ? r + 1 : r;
    }
    
    public int binSearchMin(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        
        if(r < l) {
            return 0;
        }
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return nums.get(r) < target ? r + 1 : r;
    }



    public int createSortedArrayTLE2(int[] instructions) {
        int cost = 0;
        int MOD = (int) 1e9 + 7;
        
        List<Integer> numsList = new ArrayList<>();
        numsList.add(instructions[0]);
        for (int i = 1; i < instructions.length; i++) {
            int num = instructions[i];
            if (num <= numsList.get(0)) {
                numsList.add(0, num);
            } else if (num >= numsList.get(numsList.size() - 1)) {
                numsList.add(num);
            } else {
                int insertPos = find_index(numsList, num);
                numsList.add(insertPos, num);
                cost += findCost(numsList, num);
                cost=(int) (cost % MOD);
                
            }
        }
        System.out.println(numsList);
        return (int) (cost % MOD);
    }

    public int createSortedArrayTLE(int[] instructions) {
        int cost = 0;
        List<Integer> numsList = new ArrayList<>();
        numsList.add(instructions[0]);
        for (int i = 1; i < instructions.length; i++) {
            int num = instructions[i];
            if (num <= numsList.get(0)) {
                numsList.add(0, num);
            } else if (num >= numsList.get(numsList.size() - 1)) {
                numsList.add(num);
            } else {
                for (int j = 0; j < numsList.size(); j++) {
                    if (numsList.get(j) >= num) {
                        numsList.add(j, num);
                        cost += findCost(numsList, num);
                        break;
                    }

                }
            }
        }
        System.out.println(numsList);
        return cost;
    }

    private int findCost(List<Integer> numList, int num) {

        int startIdx = 0;
        int endIdx = 0;
        startIdx = lower(numList, num);
        endIdx = upper(numList, num);
        endIdx = (numList.size() - 1) - endIdx;
        System.out.println(Math.min(startIdx, endIdx));
        return Math.min(startIdx, endIdx);

    }

    public static int lower(List<Integer> numList, int key) {
        int low = 0;
        int high = numList.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numList.get(mid) >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upper(List<Integer> numList, int key) {
        int low = 0;
        int high = numList.size() - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (numList.get(mid) <= key) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int find_index(List<Integer> numList, int num) {

        // Lower and upper bounds
        int start = 0;
        int end = numList.size() - 1;

        // Traverse the search space
        while (start <= end) {
            int mid = (start + end) / 2;

            // If K is found
            if (numList.get(mid) == num)
                return mid;

            else if (numList.get(mid) < num)
                start = mid + 1;

            else
                end = mid - 1;
        }
        return end + 1;
    }
    
    
    public int createSortedArray(int[] instructions) {
        BitTree tree = new BitTree(100002);
        long cost = 0;
        long MOD = 1000000007;

        for (int i = 0; i < instructions.length; i++) {
            int leftCost = tree.query(instructions[i] - 1);
            int rightCost = i - tree.query(instructions[i]);
            cost += Math.min(leftCost, rightCost);
            tree.add(instructions[i], 1);
        }
        
        return (int) (cost % MOD);
    }

    class BitTree {
        int[] tree;
        int m;
        public BitTree(int size) {
            tree = new int[size];
            m = size;
        }
        
        public void add(int index, int value) {
            while (index < m) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
    
    
    public int createSortedArraySol(int[] instructions) {
        if(instructions == null || instructions.length == 0) {
            return 0;
        }
        
        int max = 0;
        for(int n : instructions) max = Math.max(max, n);
        int[] arr = new int[max + 1];
        
        int res = 0, mod = (int)(1e9 + 7);
        for(int i = 0; i<instructions.length; i++) {
            res = (res + Math.min(get(arr, instructions[i] - 1), i - get(arr, instructions[i]))) % mod;
            update(arr, max, instructions[i]);
        }
        
        return res;
    }
    
    private int get(int[] arr, int i){
        int res = 0;
        while(i > 0) {
            res += arr[i];
            i -= i & (-i);
        }
        
        return res;
    }
    
    private void update(int[] arr, int n, int i){
        while(i <= n) {
            arr[i] += 1;
            i += i & (-i);
        }
    }

    public static void main(String[] args) {
        LC1649CreateSortedArrayInstructions obj = new LC1649CreateSortedArrayInstructions();
        int[] instructions = { 1, 3, 3, 3, 2, 4, 2, 1, 2 };

        // int[] instructions = { 1, 2, 3, 6, 5, 4 };
        System.out.println(Arrays.toString(instructions));
        System.out.println(obj.createSortedArray(instructions));

    }

}
