package leetcode;

public class LC1342NumberOfStepsToReduceZero {
    public int numberOfSteps(int num) {
        if (num <= 1) {
            return 0;
        }

        int cnt = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num - 1);
            }
            cnt++;
        }

        return cnt;

    }

    public static void main(String[] args) {
        LC1342NumberOfStepsToReduceZero obj = new LC1342NumberOfStepsToReduceZero();
        int num = 123;
        System.out.println(obj.numberOfSteps(num));

    }

}
