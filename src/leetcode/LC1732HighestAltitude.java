package leetcode;

public class LC1732HighestAltitude {
    public int largestAltitude(int[] gain) {

        int maxGain = 0;
        int sum = gain[0];
        maxGain = Math.max(sum, maxGain);
        for (int i = 1; i < gain.length; i++) {
            sum = sum + gain[i];
            maxGain = Math.max(sum, maxGain);
        }
        return maxGain;
    }

    public int largestAltitudeSol(int[] gain) {
        int ans = 0;
        int pre = 0;
        for (int i : gain) {
            ans = Math.max(ans, i + pre);
            pre = i + pre;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1732HighestAltitude obj = new LC1732HighestAltitude();
        int[] gain = { 52, -91, 72 };
        System.out.println(obj.largestAltitude(gain));
    }

}
