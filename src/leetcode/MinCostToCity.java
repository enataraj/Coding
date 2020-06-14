package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class MinCostToCity {

    public static void main(String[] args) {

        int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
        // int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
        int res = new MinCostToCity().twoCitySchedCost(costs);
        System.out.println("Cost :" + res);
    }

    public int twoCitySchedCost(int[][] costs) {
        TreeMap<Integer, ArrayList<Integer>> costMap = new TreeMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < costs.length; i++) {
            int key = costs[i][0] - costs[i][1];
            if (costMap.get(key) == null) {
                ArrayList<Integer> valueList = new ArrayList<>();
                valueList.add(i);
                costMap.put(key, valueList);
            } else {
                costMap.get(key).add(i);
            }
        }
        System.out.println(costMap);

        Set<Integer> keys = costMap.keySet();
        List<Integer> resIndex = new ArrayList<>();
        Iterator itr = keys.iterator();
        int res = 0;
        while (itr.hasNext()) {
            resIndex.addAll(costMap.get(itr.next()));
        }
        System.out.println(resIndex);
        int len = resIndex.size() / 2;
        for (int i = 0; i < len; i++) {
            System.out.println(costs[resIndex.get(i)][0]);
            System.out.println(costs[resIndex.get(len + i)][1]);
            res = res + costs[resIndex.get(i)][0] + costs[resIndex.get(len + i)][1];

        }
        return res;

    }

}


/*
 * 
 * 
 * 
 * class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int result = 0;
        int[] refund = new int[costs.length];
        for(int i=0; i<costs.length ; i++)
        {
            result += costs[i][0];
        }
        for(int i=0; i<costs.length; i++)
        {
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for(int i= 0; i<refund.length/2;i++)
        {
            result += refund[i];
        }
        return result;
    }
}

*/

/*
 * 
 * class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int total = 0;
        for(int i = 0; i < costs.length / 2; i++){
            total += costs[i][0];
            total += costs[i + costs.length / 2][1];
        }
        return total;
    }
}

*/
