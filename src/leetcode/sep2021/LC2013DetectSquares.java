package leetcode.sep2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2013DetectSquares {
    List<int[]> coordinateList;
    Map<String, Integer> countMap;

    public LC2013DetectSquares() {
        coordinateList = new ArrayList<>();
        countMap = new HashMap<>();
    }

    public void add(int[] point) {
        coordinateList.add(point);
        String key = point[0] + "@" + point[1];
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int result = 0;

        for (int[] coordinate : coordinateList) {
            int x = coordinate[0];
            int y = coordinate[1];
            if (px == x || py == y || Math.abs(px - x) != Math.abs(py - y)) {
                continue;
            }
            result += countMap.getOrDefault(x + "@" + py, 0) * countMap.getOrDefault(px + "@" + y, 0);

        }
        return result;

    }

    public static void main(String[] args) {
        LC2013DetectSquares obj = new LC2013DetectSquares();
        obj.add(new int[] { 3, 10 });
        obj.add(new int[] { 11, 2 });
        obj.add(new int[] { 3, 2 });
        obj.count(new int[] { 11, 10 });
        obj.add(new int[] { 11, 2 });
        System.out.println(obj.count(new int[] { 11, 10 }));

    }

    class DetectSquares {

        int[][] counts = new int[1001][1001];
        List<int[]> points = new ArrayList<>();

        public DetectSquares() {
        }

        public void add(int[] point) {
            counts[point[0]][point[1]]++;
            if (counts[point[0]][point[1]] == 1)
                points.add(point);
        }

        public int count(int[] point) {
            int x0 = point[0];
            int y0 = point[1];

            int ans = 0;
            for (int i = 0; i < points.size(); i++) {
                int x1 = points.get(i)[0];
                int y1 = points.get(i)[1];
                if (x1 != x0)
                    continue;
                for (int j = 0; j < points.size(); j++) {
                    if (i == j)
                        continue;
                    int x2 = points.get(j)[0];
                    int y2 = points.get(j)[1];
                    if (y2 != y0)
                        continue;
                    if (Math.abs(y1 - y0) != Math.abs(x2 - x0))
                        continue;
                    int a = counts[x1][y1];
                    int b = counts[x2][y2];
                    int c = counts[x2][y1];
                    ans += a * b * c;
                }
            }
            return ans;
        }
    }

}
