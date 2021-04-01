package leetcode.march;

public class LC869ReorderPowerOf2 {

    public boolean reorderedPowerOf2(int N) {

        int powerOf2 = 1;

        int[] input = new int[10];

        // Build Input frequecy map
        while (N > 0) {
            input[N % 10]++;
            N /= 10;
        }

        for (int i = 0; i < 31; i++) {
            int[] current = new int[10];
            int tmp = powerOf2;
            // Build Frequency map for all power of two's
            while (tmp > 0) {
                current[tmp % 10]++;
                tmp /= 10;
            }

            boolean isPowerOfTwo = true;
            for (int j = 0; j < 10; j++) {
                if (input[j] != current[j]) {
                    isPowerOfTwo = false;
                }
            }
            if (isPowerOfTwo)
                return true;
            powerOf2 = powerOf2 << 1;
        }
        return false;
    }

    boolean result = false;

    public boolean reorderedPowerOf2Rec(int N) {
        if (N == 1)
            return true;
        if (N < 10) {
            return isPowerOfTwo(N);

        }

        char[] chArray = (N + "").toCharArray();
        dfsHelpher(chArray, 0, chArray.length - 1);
        return result;
    }

    private void dfsHelpher(char[] chArray, int left, int right) {
        if (result) {
            return;
        }
        if (left == right && chArray[0] != '0') {
            if (isPowerOfTwo(Integer.parseInt(new String(chArray)))) {
                result = true;
            }
        }

        for (int i = left; i <= right; i++) {
            swap(chArray, left, i);
            dfsHelpher(chArray, left + 1, right);
            swap(chArray, left, i);

        }

    }

    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        LC869ReorderPowerOf2 obj = new LC869ReorderPowerOf2();
        System.out.println(obj.reorderedPowerOf2(8));
    }

}
