package leetcode.jan;

public class LC526BeautifulArrangement {
    int count = 0;

    public int countArrangementTLE(int n) {
        if (n == 1) {
            return 1;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        permutationTLE(nums, 0, n - 1);
        return count;

    }

    private void permutationTLE(int[] nums, int left, int right) {
        if (left == right) {

            if (isValid(nums)) {
                // System.out.println(Arrays.toString(nums));
                count++;
            }

        }

        for (int i = left; i <= right; i++) {
            swap(nums, left, i);
            permutationTLE(nums, left + 1, right);
            swap(nums, left, i);

        }
    }

    public int countArrangement(int n) {
        if (n == 1) {
            return 1;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        permutation(nums, 0, n);
        return count;

    }

    private void permutation(int[] nums, int left, int right) {
        if (left == right) {
            count++;
        }

        for (int i = left; i < right; i++) {
            swap(nums, i, left);
            if ((nums[left] % (left + 1)) == 0 || ((left + 1) % nums[left]) == 0) {
                permutation(nums, left + 1, right);
            }
            swap(nums, i, left);

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean isValid(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] % i != 0 && i % nums[i - 1] != 0) {
                return false;
            }
        }

        return true;

    }

    public int countArrangementSol(int n) {
        if (n == 1) {
            return 1;
        }
        permutation(1, n, new boolean[n + 1]);
        return count;

    }

    private void permutation(int left, int right, boolean[] visited) {
        if (left == right + 1) {
            count++;
        } else {
            for (int i = 1; i <= right; i++) {
                if (visited[i] || (left % i != 0 && i % left != 0)) {
                    continue;
                }
                visited[i] = true;
                permutation(left + 1, right, visited);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        LC526BeautifulArrangement obj = new LC526BeautifulArrangement();
        int n = 7;
        System.out.println(obj.countArrangement(n));
    }

}
