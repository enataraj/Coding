package leetcode;

public class LC1672RichestCustomerwealth {
    public int maximumWealth(int[][] accounts) {

        if (accounts == null || accounts.length == 0) {
            return 0;
        }

        int wealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tmp = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                tmp += accounts[i][j];
            }
            wealth = Math.max(tmp, wealth);

        }

        return wealth;

    }

    public int maximumWealthSol(int[][] accounts) {
        int max = 0;
        for (int[] a : accounts) {
            int sum = 0;
            for (int i : a)
                sum += i;
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LC1672RichestCustomerwealth obj = new LC1672RichestCustomerwealth();
        int[][] accounts = { { 1, 2, 3 }, { 3, 2, 1 } };
        System.out.println(obj.maximumWealth(accounts));

    }

}
