package leetcode.june;

import java.util.Arrays;

public class RangeSumMutable {

    int[] tree;
    int[] nums;
    int size;

    public RangeSumMutable(int[] nums) {
        this.size = nums.length;
        this.tree = new int[size + 1];
        this.nums = new int[size];
        this.nums = nums;
        for (int i = 0; i < size; i++) {
            updateTree(i, nums[i]);
        }
    }

    public void updateTree(int i, int val) {
        i = i + 1;
        System.out.print(i + "  ");
        while (i <= size) {
            tree[i] += val;
            i += i & (-i); // the last set bit/ Two's complement
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(tree));
    }

    public void update(int i, int val) {
        updateTree(i, val - nums[i]);
        nums[i] = val;
    }

    private int getSum(int i) {
        int sum = 0;
        i = i + 1;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);// Another tree, go to the ancestor
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return getSum(j);
        return getSum(j) - getSum(i - 1);
    }

    /*  
     Algo as follows
    1) Find the total sum , when ever update called, subtract the old number and add the new val to total sum.
    
    2) When Ranges Sum Called, Subtract 0 to left and right to rest of the numbers.
    
    3) Return the result.
    
    1-20
    5,10
    
    
    0-4
    11-20
    
    
    5-10
    
    0--- 20
    
    total sum 
    
    update
    
    
    3-15
    
    0-2 --> 
    16-20 --> 
    
    
    
    
    
    */
    class NumArray {

        int[] a;
        int s = 0;

        public NumArray(int[] nums) {
            a = nums;
            for (int i = 0; i < nums.length; i++)
                s += nums[i];
        }

        public void update(int index, int val) {

            s -= a[index];
            s += val;
            a[index] = val;
            //System.out.println(s);
        }

        public int sumRange(int left, int right) {
            int s1 = s;
            if (left == right) {
                s1 = a[left];
            } else {
                if (left > 0) {
                    for (int i = 0; i < left; i++) {
                        s1 -= a[i];
                    }
                }
                if (a.length > 2 && right <= a.length - 2) {
                    for (int i = right + 1; i < a.length; i++)
                        s1 -= a[i];
                }
            }
            return s1;
        }
    }

    public static void main(String[] args) {

        int[] nums = { 3, 4, 6, 2, 6, 7, 2, 8 };
        RangeSumMutable obj = new RangeSumMutable(nums);
        // System.out.println(obj.);
    }

}
