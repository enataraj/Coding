package leetcode.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class LC315CountSmalleNumberAfterSelf {
    
    
    public List<Integer> countSmaller(int[] nums) {
       
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(0);
        sortedList.add(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--) {
            int val = nums[i];
            for(int j=0;j<sortedList.size();j++) {
               
                
                
            }
        }
        return null;
    }
    
    
    private int findInsertPos(List<Integer> list) {

        int left = 0;
        int right = list.size();
        int mid = 0;


        while(left< right)  {
            mid = (left + right)/2;
            int result = list.get(mid);


            if(result > 0) { //If e is lower
                right = mid;
            } else { //If e is higher
                left = mid + 1;
            }
        }

       return left; 
    }
    

    public List<Integer> countSmallerTLE(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(TreeNode node, int val) {
        int thisCount = 0;
        while (true) {
            if (val <= node.val) {
                node.count++;
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                thisCount += node.count;
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return thisCount;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int count = 1;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Data implements Comparable<Data> {
    int val;
    int idx;

    public Data(int val, int idx) {
        this.val = val;
        this.idx = idx;

    }

    @Override
    public int compareTo(Data data) {
        if (data.val == val) {
            return idx - data.idx;
        }
        return val - data.val;

    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "(" + val + "," + idx + ")";
    }

    public List<Integer> countSmallerTLE(int[] nums) {

        TreeMap<Data, Integer> map = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(new Data(nums[i], i), 0);
        }

        for (int i = 0; i < nums.length; i++) {
            Data curData = new Data(nums[i], i);
            Data lowerKey = map.lowerKey(curData);

            while (lowerKey != null) {

                if (lowerKey.idx > i) {

                    int value = map.get(lowerKey) + 1;
                    map.put(curData, map.get(curData) + value);
                }
                lowerKey = map.lowerKey(lowerKey);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            result.add(map.get(new Data(nums[i], i)));
        }

        return result;

    }

    public static void main(String[] args) {
        LC315CountSmalleNumberAfterSelf obj = new LC315CountSmalleNumberAfterSelf();
        int[] nums = { 5, 2, 6, 1 };
        // int[] nums = { 2, 0, 1 };
        //  int[] nums = { -1,-1 };
        //int[] nums = { -1 };

        // int [] nums  = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        // int[] nums = { 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100,41 };

        System.out.println(obj.countSmaller(nums));
    }

}
