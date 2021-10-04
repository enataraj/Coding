package leetcode.sep2021;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<Integer>();

        while (left <= right && top <= bottom) {
            // left to right
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;
            // right to left
            if (top <= bottom)
                for (int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
            bottom--;
            // bottom to top
            if (left <= right)
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
            left++;
        }
        return result;
    }

    public double minmaxGasDist(int[] stations, int k) {
        int N = stations.length;
        double left = 0, right = stations[N - 1] - stations[0];
        while ((right - left) > 1e-6) {
            double mid = (right + left) / 2.0;
            if (possible(stations, k, mid))
                right = mid;
            else
                left = mid;
        }
        return left;
    }

    private boolean possible(int[] stations, int k, double distance) {
        int count = 0;
        for (int index = 1; index < stations.length; index++) {
            count += (int) ((stations[index] - stations[index - 1]) / distance);
            if (count > k)
                return false;
        }
        return count <= k;
    }
    
    
}
