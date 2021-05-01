package leetcode.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Weekly237 {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 97; i < 123; i++) {
            char ch = (char) i;
            set.add(ch);
        }

        for (char ch : sentence.toCharArray()) {
            set.remove(ch);
            if (set.size() == 0) {
                return true;
            }
        }
        if (set.size() == 0) {
            return true;
        }
        return false;

    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        int sum = 0;
        for (int cost : costs) {
            sum += cost;
            if (sum > coins) {
                return result;
            }
            result++;
            if (sum == coins) {
                return result;
            }

        }
        return result;

    }

    public int[] getOrder(int[][] tasks) {

        Map<String, Integer> inputMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int startTime = tasks[i][0];
            int endTime = tasks[i][0] + tasks[i][1];
            String key = startTime + "#" + endTime;
            inputMap.put(key, i);

        }

        Arrays.sort(tasks, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] task : tasks) {
            task[1] = task[0] + task[1];

        }

       for (int i = 0; i < tasks.length; i++) {
            System.out.println(Arrays.toString(tasks[i]));
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < tasks.length; i++) {
            int endTime = tasks[i][1];
            int startTime = tasks[i][0];
            String key = startTime + "#" + endTime;
            if (map.containsKey(endTime)) {
                List<Integer> list = map.get(endTime);
                list.add(inputMap.get(key));
                map.put(endTime, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(inputMap.get(key));
                map.put(endTime, list);
            }

        }

        int[] result = new int[tasks.length];
        int idx = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int num : list) {
                result[idx++] = num;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Weekly237 obj = new Weekly237();
        obj.checkIfPangram("abc");

        int[] costs = { 1, 6, 3, 1, 2, 5 };
        int coins = 20;
        System.out.println(obj.maxIceCream(costs, coins));

       // int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
        //[6,1,2,9,4,10,0,11,5,13,3,8,12,7] -- expected
        //[6,1,2,0,13,11,9,4,10,3,8,5,7,12] -- mine
       // int[][] tasks = { { 7, 10 }, { 7, 12 }, { 7, 5 }, { 7, 4 }, { 7, 2 } };
        
        int[][] tasks = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};

        System.out.println(Arrays.toString(obj.getOrder(tasks)));
    }

}
