package leetcode.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPaths {

    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(edges, 0, path, result);
        return result;

    }

    private void helper(int[][] edges, int u, List<Integer> path, List<List<Integer>> result) {
        if (u == edges.length - 1) {
            List<Integer> tmpList = new ArrayList();
            tmpList.addAll(path);
            result.add(tmpList);

            return;
        }
        for (int i = 0; i < edges[u].length; i++) {
            path.add(edges[u][i]);
            helper(edges, edges[u][i], path, result);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {

        AllPaths obj = new AllPaths();
        int[][] edges = { { 1, 2 }, { 3 }, { 3 }, {} };
        System.out.println(obj.allPathsSourceTarget(edges));

    }
}
