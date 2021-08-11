package leetcode.aug2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC1632RankMatrix {
    private int find(int x, int parent[]) {
        if (parent[x] == x)
            return x;
        else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }

    private void union(int x, int y, int parent[]) {
        int xparent = find(x, parent);
        int yparent = find(y, parent);
        parent[yparent] = xparent;
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][0];

        int n = matrix.length;
        int m = matrix[0].length;

        //Add same value in a same group
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                List<int[]> list = treeMap.getOrDefault(matrix[row][col], new ArrayList<>());
                list.add(new int[] { row, col });
                treeMap.put(matrix[row][col], list);
            }
        }

        int[] minX = new int[n];
        int[] minY = new int[m];
        int[][] rankMatrix = new int[n][m];
        for (Map.Entry<Integer, List<int[]>> sameValueEntry : treeMap.entrySet()) {
            ArrayList<int[]> sameValueGroup = new ArrayList<>(sameValueEntry.getValue());

            //Create union and find data structure
            int[] parent = new int[sameValueGroup.size()];
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;

            //sameValueGroup values should be grouped by same column and same row
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for (int i = 0; i < sameValueGroup.size(); i++) {
                int[] point = sameValueGroup.get(i);
                List<Integer> xList = xMap.getOrDefault(point[0], new ArrayList<>());
                List<Integer> yList = yMap.getOrDefault(point[1], new ArrayList<>());

                xList.add(i);
                yList.add(i);
                xMap.put(point[0], xList);
                yMap.put(point[1], yList);
            }

            for (Map.Entry<Integer, List<Integer>> xEntrySet : xMap.entrySet()) {
                List<Integer> xList = xEntrySet.getValue();
                for (int i = 1; i < xList.size(); i++) {
                    union(xList.get(i - 1), xList.get(i), parent);
                }
            }

            for (Map.Entry<Integer, List<Integer>> yEntrySet : yMap.entrySet()) {
                List<Integer> yList = yEntrySet.getValue();
                for (int i = 1; i < yList.size(); i++) {
                    union(yList.get(i - 1), yList.get(i), parent);
                }
            }

            //Group them in HashMap so that they can be iterated
            HashMap<Integer, List<int[]>> sameRowColGroup = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int group = find(i, parent);
                List<int[]> list = sameRowColGroup.getOrDefault(group, new ArrayList<>());
                list.add(sameValueGroup.get(i));
                sameRowColGroup.put(group, list);
            }

            for (Map.Entry<Integer, List<int[]>> sameRowColEntry : sameRowColGroup.entrySet()) {
                int rank = 0;
                List<int[]> sameRowColValue = sameRowColEntry.getValue();

                for (int[] point : sameRowColValue) {
                    rank = Math.max(rank, minX[point[0]]);
                    rank = Math.max(rank, minY[point[1]]);
                }

                for (int[] point : sameRowColValue) {
                    rankMatrix[point[0]][point[1]] = rank + 1;
                    minX[point[0]] = rank + 1;
                    minY[point[1]] = rank + 1;
                }
            }
        }
        return rankMatrix;
    }

    class Solution {
        public int[][] matrixRankTransform(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            Map<Integer, List<int[]>> map = new TreeMap();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int v = matrix[i][j];
                    map.computeIfAbsent(v, k -> new ArrayList()).add(new int[] { i, j });
                }
            }

            int[] rank = new int[m + n];
            for (int key : map.keySet()) {
                List<int[]> posList = map.get(key);
                int[] rank2 = rank.clone();

                DSU dsu = new DSU(m + n);

                for (int[] pos : posList) {
                    int s0 = dsu.find(pos[0]), s1 = dsu.find(pos[1] + m);
                    dsu.union(s0, s1);
                    rank2[s1] = Math.max(rank2[s0], rank2[s1]);
                }

                for (int[] pos : posList) {
                    int p0 = pos[0], p1 = pos[1];
                    rank[p0] = rank[p1 + m] = matrix[p0][p1] = rank2[dsu.find(p0)] + 1;
                }
            }
            return matrix;
        }

        class DSU {
            int[] parent;

            public DSU(int n) {
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
        }
    }
}
