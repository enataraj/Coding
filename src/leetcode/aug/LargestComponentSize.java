package leetcode.aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponentSize {

    public int largestComponentSize(int[] A) {

        int res = 0;
        if (A == null) {
            return res;
        }

        if (A.length == 1) {
            return 1;
        }

        /*
         * int maxNum = Integer.MIN_VALUE; for (int i = 0; i < A.length; i++) { if (A[i]
         * > maxNum) { maxNum = A[i]; }
         * 
         * }
         */

        Map<Integer, Set<Integer>> commonComponentMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            int sqtNum = (int) Math.sqrt(num);

            for (int j = 2; j <= sqtNum; j++) {
                if (num % j == 0) {
                    if (commonComponentMap.containsKey(j)) {
                        Set<Integer> connectedSet = commonComponentMap.get(j);
                        connectedSet.add(num);
                        commonComponentMap.put(j, connectedSet);

                    } else {
                        Set<Integer> connectedSet = new HashSet<>();
                        connectedSet.add(num);
                        commonComponentMap.put(j, connectedSet);

                    }

                    int k = num / j;
                    if (commonComponentMap.containsKey(k)) {
                        Set<Integer> connectedSet = commonComponentMap.get(k);
                        connectedSet.add(num);
                        commonComponentMap.put(k, connectedSet);

                    } else {
                        Set<Integer> connectedSet = new HashSet<>();
                        connectedSet.add(num);
                        commonComponentMap.put(k, connectedSet);

                    }

                }
            }

        }
        System.out.println(commonComponentMap);

        int[] keys = new int[commonComponentMap.size()];
        int idx = 0;
        for (int key : commonComponentMap.keySet()) {
            keys[idx] = key;
            idx++;
        }
        
        for(int i=0;i<keys.length;i++) {
            Set<Integer> connectedSet = commonComponentMap.get(keys[i]);
            for(int j=i+1;j<keys.length;j++) {
                
            }
            
        }

        return res;

    }

    public int largestComponentSizeSol(int[] A) {
        int largest = -1;
        for (Integer num : A) {
            largest = Math.max(num, largest);
        }
        int[] parents = new int[largest + 1];
        Arrays.fill(parents, -1);
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            // System.out.println("num" + num);
            int sq = (int) Math.sqrt(num);
            // System.out.println("sq" + sq);
            List<Integer> list = new ArrayList();
            for (int j = 2; j <= sq; j++) {
                if (num % j == 0) {
                    list.add(j);
                    list.add(num / j);
                }
            }
            list.add(num);
            // System.out.println(list.toString());
            for (int k = 0; k < list.size() - 1; k++) {
                union(list.get(k), list.get(k + 1), parents);
            }
        }

        /*
         * for (int i=0; i<parents.length; i++){ System.out.print(parents[i]+","); }
         * System.out.println();
         */

        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int p = find(A[i], parents);
            // System.out.println("Parent of num " + A[i] + " is " + p );
            int count = map.getOrDefault(p, 0) + 1;
            map.put(p, count);
            max = Math.max(max, count);
        }
        return max;
    }

    private void union(int p1, int p2, int[] parents) {
        int pp1 = find(p1, parents);
        int pp2 = find(p2, parents);
        // System.out.println("p1 : " + p1 + ", pp1:" + pp1);
        // System.out.println("p2 : " + p2 + ", pp2:" + pp2);
        if (pp1 != pp2) {
            parents[pp2] = pp1;
        }
    }

    private int find(int p1, int[] parents) {
        int parent = parents[p1];
        while (parent != -1) {
            p1 = parents[p1];
            parent = parents[p1];
        }
        return p1;
    }

    public static void main(String[] args) {
        LargestComponentSize obj = new LargestComponentSize();
        int[] A = { 4, 6, 15, 35 };
        System.out.println(obj.largestComponentSize(A));

    }

}
