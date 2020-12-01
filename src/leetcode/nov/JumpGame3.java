package leetcode.nov;

import java.util.HashSet;
import java.util.Set;

public class JumpGame3 {
    boolean res = false;
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        dfsHelpher(arr, start, visited);
        return res;
    }

    private void dfsHelpher(int[] arr, int idx, Set<Integer> visited) {

        if (arr[idx] == 0) {
            res = true;
            return;
        }
        System.out.println("idx  : " + idx + "  Value " + arr[idx]);

        if (idx + arr[idx] < arr.length && idx + arr[idx] >= 0 && !visited.contains(idx + arr[idx])) {
            visited.add(idx + arr[idx]);
            dfsHelpher(arr, idx + arr[idx], visited);
        }

        if (idx - arr[idx] < arr.length && idx - arr[idx] >= 0 && !visited.contains(idx - arr[idx])) {
            visited.add(idx - arr[idx]);
            dfsHelpher(arr, idx - arr[idx], visited);
        }

    }
    
    
    public boolean canReachSol(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return travel(arr, start, visited);
    }
    // DFS
    private boolean travel(int[] arr, int index, boolean[] visited){
        if (index < 0 || index > arr.length - 1 || visited[index]) {
            return false;
        }
        visited[index] = true;
        if (arr[index] == 0) {
            return true;
        }
        int left = index + arr[index];
        int right = index - arr[index];
        return travel(arr, left, visited) || travel(arr, right, visited);
    }

    public static void main(String[] args) {
        JumpGame3 obj = new JumpGame3();
         int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
         int start = 5;

        //int[] arr = { 3, 0, 2, 1, 2 };
       // int start = 2;

        System.out.println(obj.canReach(arr, start));

    }

}
