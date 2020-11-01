package leetcode.oct;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].

 */

public class MaxDistanceInArray {

    public int maxDistance(List<List<Integer>> arrays) {
        return 0;
    }

    public static void main(String[] args) {
        MaxDistanceInArray obj = new MaxDistanceInArray();
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        arrays.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(5);
        arrays.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        arrays.add(list);

        System.out.println(obj.maxDistance(arrays));
    }

}
