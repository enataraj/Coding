package leetcode;

public class LC507PerfectNumber {

    public boolean checkPerfectNumberSol(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != Math.sqrt(num)) {
                    sum += num / i;
                }
            }
        }
        if (sum == 2 * num) {
            return true;
        }
        return false;
    }

    public boolean checkPerfectNumber(int num) {

        int temp = num;
        int sum = 0;
        while (temp % 2 == 0) {
            temp = temp / 2;
            sum += temp;
        }
        temp -= 1;
        while (temp != 0) {
            if (num % temp == 0) {
                sum += temp;
            }
            temp--;
        }
        return sum == num;

    }

    public boolean checkPerfectNumberSort(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    public static void main(String[] args) {
        LC507PerfectNumber obj = new LC507PerfectNumber();

        System.out.println(obj.checkPerfectNumber(496));

    }

}
