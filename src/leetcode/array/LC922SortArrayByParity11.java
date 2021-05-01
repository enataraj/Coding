package leetcode.array;

public class LC922SortArrayByParity11 {

    public int[] sortArrayByParityIISol3(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;
        while (evenIndex < nums.length && oddIndex < nums.length) {
            while (evenIndex < nums.length && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }

            while (oddIndex < nums.length && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            if (evenIndex >= nums.length && oddIndex >= nums.length)
                break;

            if (nums[evenIndex] % 2 == 1 && nums[oddIndex] % 2 == 0) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }
        return nums;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int oddIdx = -1;
        int evenIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] % 2 != 0 && evenIdx == -1) {
                evenIdx = i;
            }

            if (i % 2 == 1 && nums[i] % 2 != 1 && oddIdx == -1) {
                oddIdx = i;
            }
            if (evenIdx != -1 && oddIdx != -1) {
                int tmp = nums[oddIdx];
                nums[oddIdx] = nums[evenIdx];
                nums[evenIdx] = tmp;
                i = Math.min(oddIdx, evenIdx);
                oddIdx = -1;
                evenIdx = -1;

            }
        }

        return nums;

    }

    public int[] sortArrayByParityIISol(int[] nums) {
        int n = nums.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if ((nums[i] & 1) != 0) {
                while ((nums[j] & 1) != 0)
                    j += 2;
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
            }
        }
        return nums;
    }

    public int[] sortArrayByParityIISol2(int[] nums) {
        int[] result = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[even] = nums[i];
                even = even + 2;
            } else {
                result[odd] = nums[i];
                odd = odd + 2;
            }
        }
        return result;
    }

}
