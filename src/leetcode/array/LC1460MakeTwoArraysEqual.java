package leetcode.array;

public class LC1460MakeTwoArraysEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] tmpArray = new int[1000];
        int idx;
        for (int i = 0; i < target.length; i++) {
            idx = target[i] - 1;
            System.out.println(idx);

            tmpArray[idx] = tmpArray[idx] + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            idx = arr[i] - 1;
            tmpArray[idx] = tmpArray[idx] - 1;
        }

        for (int i = 0; i < tmpArray.length; i++) {
            if (tmpArray[i] != 0) {
                return false;
            }
        }

        return true;

    }

    public boolean canBeEqualSol(int[] target, int[] arr) {
        if (arr.length != target.length)
            return false;
        int sum = 0, ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans ^= target[i];
            ans ^= arr[i];
            sum += target[i];
            sum -= arr[i];
        }

        return sum == 0 && ans == 0;
    }

    public static void main(String[] args) {
        LC1460MakeTwoArraysEqual obj = new LC1460MakeTwoArraysEqual();
        int[] target = { 1, 2, 3, 4 };
        int[] arr = { 2, 4, 1, 3 };
        System.out.println(obj.canBeEqual(target, arr));

    }

}
