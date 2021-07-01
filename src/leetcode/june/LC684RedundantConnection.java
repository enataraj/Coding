package leetcode.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC684RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            if (!isFormingCyclic(new HashSet<Integer>(), adjList, edge[0], edge[1])) {
                Set<Integer> set = adjList.getOrDefault(edge[0], new HashSet<Integer>());
                set.add(edge[1]);
                adjList.put(edge[0], set);

                set = adjList.getOrDefault(edge[1], new HashSet<Integer>());
                set.add(edge[0]);
                adjList.put(edge[1], set);
            } else {

                return edge;
            }
        }

        return null;

    }

    private boolean isFormingCyclic(Set<Integer> visited, Map<Integer, Set<Integer>> adjList, int source,
            int destination) {
        if (source == destination) {
            return true;
        }
        visited.add(source);
        if (adjList.get(source) != null) {

            for (int node : adjList.get(source)) {
                if (!visited.contains(node)) {

                    if (isFormingCyclic(visited, adjList, node, destination)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class DSU {
        int[] id;
        int[] size;

        public DSU(int N) {
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (id[x] != x)
                id[x] = find(id[x]);
            return id[x];
        }

        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py)
                return false;
            if (size[px] < size[py]) {
                id[px] = py;
                size[py] += size[px];
            } else {
                id[py] = px;
                size[px] += size[py];
            }
            return true;
        }
    }

    public int[] findRedundantConnectionUnionFind(int[][] edges) {
        int maxEdges = 1000;
        DSU dsu = new DSU(maxEdges + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1]))
                return edge;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LC684RedundantConnection obj = new LC684RedundantConnection();
    }

}
