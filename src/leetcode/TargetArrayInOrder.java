package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetArrayInOrder {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            index[i] = list.get(i);
        }
        return index;

    }
    
    

    public static void main(String[] args) {
        int nums[] = { 0, 1, 2, 3, 4 };
        int index[] = { 0, 1, 2, 2, 1 };
        int[] res = new TargetArrayInOrder().createTargetArray(nums, index);
        System.out.println(Arrays.toString(res));

    }

}
