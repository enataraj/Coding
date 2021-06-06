package leetcode.array;

public class LC1716CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int result = 0;
        int reminder = n / 7;
        int mod = n % 7;

        for (int i = 0; i < reminder; i++) {
            result += (((7 + i) * (8 + i)) / 2) - ((i * (i + 1)) / 2);
        }
        for (int i = reminder + 1; i <= reminder + mod; i++) {
            result += i;
        }

        return result;

    }
    
    public int totalMoneySol(int n) {
        int full = n / 7;
        int res = 0;
        for (int i = 1; i <= full; ++i)
            res += 7 * (i + 3);
        for (int i = 7 * full; i < n; ++i)
            res += ++full;
        return res;
    }

    public static void main(String[] args) {
        LC1716CalculateMoneyInLeetcodeBank obj = new LC1716CalculateMoneyInLeetcodeBank();
        System.out.println(obj.totalMoney(6));

    }

}
