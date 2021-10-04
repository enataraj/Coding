package leetcode.aug2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC1986MinimumNuberOfWorkSession {

    public int minSessions(int[] tasks, int sessionTime) {
        //reverse order sort
        tasks = Arrays.stream(tasks).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        //Key is tasks[i], Value is counter
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        int count = 0;
        for (int t : tasks) {
            if (map.get(t) > 0) {
                map.put(t, map.get(t) - 1);
                int cur = t;
                int temp = sessionTime - cur;
                while (cur < sessionTime) {
                    if (map.getOrDefault(temp, 0) > 0) {
                        cur += temp;
                        map.put(temp, map.get(temp) - 1);
                    } else {
                        temp--;
                        if (temp == 0) {
                            break;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    /* public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int sum = 0;
        int result = 0;
    
        int left = 0;
        int right = tasks.length - 1;
    
        while (left < right) {
            if (tasks[right] + tasks[left] > sessionTime) {
                right--;
                result++;
                System.out.println("iiiii "+result);
            } else {
                sum = 0;
                int tmpResult = 0;
                int i = left;
                for (i = left; i < right; i++) {
                    if (sum + tasks[i] < sessionTime) {
                        tmpResult++;
                        sum += tasks[i];
                    } else {
                        break;
                    }
                }
                if (tmpResult > 2) {
                    left = i + left;
                    result += 1;
                    System.out.println("iiiddsdii "+result);
                } else {
                    left++;
                    right--;
                    result += 1;
                    System.out.println("iiiddsdii "+result);
                }
            }
        }
        
        return result;
    }*/

    public static void main(String[] args) {
        LC1986MinimumNuberOfWorkSession obj = new LC1986MinimumNuberOfWorkSession();
        int[] tasks = { 7, 4, 3, 8, 10 };
        int sessionTime = 12;
        System.out.println(obj.minSessions(tasks, sessionTime));

        /*
         * 
        [1,2,3]
        3
        [3,1,3,1,1]
        8
        [1,2,3,4,5]
        15
        
        2
        2
        1
        
        
         */
    }

}
