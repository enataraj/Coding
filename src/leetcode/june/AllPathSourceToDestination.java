package leetcode.june;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathSourceToDestination {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<Integer>();
        return dfs(graph, source, destination, visited);
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++)
            graph[v] = new ArrayList<Integer>();
        for (int[] edge : edges)
            graph[edge[0]].add(edge[1]);
        return graph;
    }

    boolean dfs(List<Integer>[] graph, int source, int destination, Set<Integer> visited) {
        if (graph[source].size() == 0)
            return source == destination;
        for (int neighbor : graph[source]) {
            if (visited.contains(neighbor))
                return false;
            visited.add(neighbor);
            if (!dfs(graph, neighbor, destination, visited))
                return false;
            visited.remove(neighbor);
        }
        return true;
    }

}
