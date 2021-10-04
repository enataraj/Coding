package leetcode.aug2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC1971FindIfPathExists {

    public boolean validPathSol(int n, int[][] edges, int start, int end) {
        boolean[] used = new boolean[n];
        used[start] = true;
        boolean newUsedFound = true;
        while (!used[end] && newUsedFound) {
            newUsedFound = false;
            for (int i = edges.length - 1; i >= 0; i--) {
                if (used[edges[i][0]]) {
                    if (!used[edges[i][1]])
                        newUsedFound = used[edges[i][1]] = true;
                } else if (used[edges[i][1]]) {
                    newUsedFound = used[edges[i][0]] = true;
                }
            }
        }
        return used[end];
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> verSet = graph.getOrDefault(edge[0], new HashSet<>());
            verSet.add(edge[1]);
            graph.put(edge[0], verSet);
            verSet = graph.getOrDefault(edge[1], new HashSet<>());
            verSet.add(edge[0]);
            graph.put(edge[1], verSet);

        }
        System.out.println(graph);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        // visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int node = queue.poll();
            if (node == end) {
                return true;
            }
            if (!visited[node]) {
                if (graph.containsKey(node)) {
                    if (graph.get(node).contains(end)) {
                        return true;
                    }
                    queue.addAll(graph.get(node));
                }
                visited[node] = true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        LC1971FindIfPathExists obj = new LC1971FindIfPathExists();
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        System.out.println(obj.validPath(3, edges, 0, 2));
    }

}
