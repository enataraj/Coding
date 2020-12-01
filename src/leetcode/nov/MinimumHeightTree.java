package leetcode.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] degrees = new int[n];

        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new HashSet<>());
            graph.get(e[0]).add(e[1]);
            graph.putIfAbsent(e[1], new HashSet<>());
            graph.get(e[1]).add(e[0]);

            ++degrees[e[0]];
            ++degrees[e[1]];
        }

        List<Integer> res = new ArrayList<>(), leaves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                leaves.add(i);
            }
        }

        int edgeCount = edges.length;
        boolean[] visited = new boolean[n];

        while (edgeCount > 1) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                visited[leaf] = true;
                if (graph.containsKey(leaf)) {
                    for (int next : graph.get(leaf)) {
                        if (visited[next]) {
                            continue;
                        }

                        --edgeCount;
                        --degrees[next];

                        if (degrees[next] == 1) {
                            newLeaves.add(next);
                        }
                    }
                }
            }

            leaves = newLeaves;
            System.out.println(leaves);
        }

        return leaves;
    }
    
    
    public List<Integer> findMinHeightTrees_1(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        
        ArrayList<Integer> adjlist[] = new ArrayList[n];
        ArrayList<Integer> leaves  =new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
           adjlist[i] = new ArrayList();
        }
        int indegree[]  = new int[n];
        for (int[] edge: edges){
            adjlist[edge[0]].add(edge[1]);
            adjlist[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        for (int i = 0; i < n; i++)
            if (indegree[i] == 1) leaves.add(i);
        
        ArrayList temp;
        while(n > 2){
            temp = new ArrayList<Integer>();
            for (Integer v: leaves){
                for (Integer av: adjlist[v]){
                    indegree[av]--;
                    if (indegree[av] == 1) temp.add(av);
                }
            }
            n -= leaves.size();
            leaves = temp;
        }
        return leaves;
        
 }

    public static void main(String[] args) {

        MinimumHeightTree obj = new MinimumHeightTree();
        int n = 6;
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        System.out.println(obj.findMinHeightTrees(n, edges));

    }

}
