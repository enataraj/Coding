package leetcode.feb;

import java.util.LinkedList;
import java.util.Queue;

public class LC785GraphIsBiPartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int n : graph[node]) {
                        if (color[n] == color[node])
                            return false;

                        else if (color[n] == 0) {
                            queue.add(n);
                            color[n] = -color[node];
                        }

                    }
                }

            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && !validColor(graph, color, 1, i)) {
                return false;
            }
        }
        return true;

    }

    private boolean validColor(int[][] graph, int[] color, int c, int node) {
        if (color[node] != 0) {
            return color[node] == c;
        }
        color[node] = c;

        for (int n : graph[node]) {
            if (!validColor(graph, color, -c, n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC785GraphIsBiPartite obj = new LC785GraphIsBiPartite();
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(obj.isBipartite(graph));

    }

}
