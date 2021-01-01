package leetcode;

public class LC1281SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        long product = 1;
        int sum = 0;

        while (n > 0) {

            product *= n % 10;
            sum += n % 10;
            n = n / 10;
            
        }

        return (int) product - sum;

    }

    public static void main(String[] args) {
        LC1281SubtractProductAndSum obj = new LC1281SubtractProductAndSum();
        int n = 123;
        System.out.println(obj.subtractProductAndSum(n));
    }

}
