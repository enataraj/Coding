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

    public int numberOfStepsReduce(int num) {
        int steps = 0;
        while (num > 1) {
            if ((num & 1) == 1) {
                ++steps;

            }

            num >>= 1;
            ++steps;
        }

        if (num > 0) {
            ++steps;
        }

        return steps;
    }

    private int numberOfStepsSrikanth(int num) {
        if (num < 2)
            return num;
        int ret = 0;
        while (num > 0) {
            if (num == 1 || num % 2 == 0)
                ret++;
            else
                ret += 2;
            num = num / 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        LC1342NumberOfStepsToReduceZero obj = new LC1342NumberOfStepsToReduceZero();
        int num = 53;
        System.out.println(obj.numberOfSteps(num));

    }

}
