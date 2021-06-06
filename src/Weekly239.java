public class Weekly239 {

    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                int idx = i - 1950;
                years[idx]++;
            }
        }
        int result = 0;
        int maxValue = 0;

        for (int i = 0; i < 101; i++) {
            if (maxValue < years[i]) {

                result = 1950 + i;
                maxValue = years[i];
            }
            System.out.println(maxValue);
        }
        return result;
    }

    public int maxDistanceTLE(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;

    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int num2 = nums2[nums2.length - 1];
        int result1 = 0;

        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1[i] <= num2) {
                result1 = nums1.length - i;
            }
        }
        int result2 = 0;
        int num1 = nums1[nums1.length - 1];
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] <= num1) {
                result2 = nums2.length - i;
            }

        }
        return Math.max(result2, result1);

    }

    public int maxDistanceBin(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = nums2.length - 1; j > i; j--) {
                if (nums1[i] > nums2[j]) {
                    result = Math.max(result, j - i);
                    break;
                }
            }
        }
        return result;

    }

    public int maxSumMinProduct(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                min = Math.min(min, nums[j]);
                result = Math.max(result, ((sum * min)% 1000000007));
            }
        }
        return (int) (result % 1000000007);

    }

    public static void main(String[] args) {
        Weekly239 obj = new Weekly239();
        int[][] logs = { { 2008, 2026 }, { 2004, 2008 }, { 2034, 2035 }, { 1999, 2050 }, { 2049, 2050 }, { 2011, 2035 },
                { 1966, 2033 }, { 2044, 2049 } };
        // System.out.println(obj.maximumPopulation(logs));

        //  int[] nums1 = { 30, 29, 19, 5 };
        //int[] nums2 = { 25, 25, 25, 25, 25 };
        // int[] nums1 = {2,2,2};
        //int[] nums2 = {10,10,1};
        int[] nums1 = { 5, 4 };
        int[] nums2 = { 3, 2 };
        System.out.println(obj.maxDistanceBin(nums1, nums2));

    }

}
