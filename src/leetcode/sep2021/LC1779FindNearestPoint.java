package leetcode.sep2021;

public class LC1779FindNearestPoint {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int dx = 0;
        int dy = 0;
        int smallestDistance = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < points.length; i++) {
            dx = x - points[i][0];
            dy = y - points[i][1];
            if (dx * dy == 0) {
                int curDistance = (Math.abs(dx) + Math.abs(dy));
                if (smallestDistance > curDistance) {
                    smallestDistance = curDistance;
                    result = i;
                }
            }
        }
        return result;

    }

}
