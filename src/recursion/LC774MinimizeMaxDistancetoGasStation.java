package recursion;

/*
 * 
 * Simialr Questions
 * 
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * 
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * 
 * https://leetcode.com/problems/divide-chocolate/
 * 
 * 
 * https://leetcode.com/problems/koko-eating-bananas/
 * 
 * 
 */
public class LC774MinimizeMaxDistancetoGasStation {

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
