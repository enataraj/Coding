package leetcode.unionfind;

import java.util.Arrays;

public class UnionFind {

    // Union Find Template
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py)
            parent[px] = py;
    }
    
    
    
    //

    public class Solution {
        int find(int parent[], int i) {
            if (parent[i] == -1)
                return i;
            return find(parent, parent[i]);
        }

        void union(int parent[], int x, int y) {
            int xset = find(parent, x);
            int yset = find(parent, y);
            if (xset != yset)
                parent[xset] = yset;
        }

        public int findCircleNum(int[][] M) {
            int[] parent = new int[M.length];
            Arrays.fill(parent, -1);
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] == 1 && i != j) {
                        union(parent, i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == -1)
                    count++;
            }
            return count;
        }
    }

}
