package leetcode.sep2021;

public class LC978LongestTurbulentSubArray {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int left = 0;
        int right = left + 1;
        int result = 1;

        while (right < arr.length) {
            right = left + 1;
            if (right < arr.length && arr[left] == arr[right]) {
                left = left + 1;
                continue;
            }
            while (right < arr.length) {
                if (isTurbulent(arr, right)) {
                    right++;

                } else {
                    result = Math.max(result, right - left + 1);
                    left = right;
                    break;

                }
            }
        }
        return result;

    }

    private boolean isTurbulent(int[] arr, int idx) {
        return (idx > 0 && idx < arr.length - 1 && ((arr[idx - 1] < arr[idx] && arr[idx] > arr[idx + 1])
                || (arr[idx - 1] > arr[idx] && arr[idx] < arr[idx + 1])));

    }

    public static void main(String[] args) {
        LC978LongestTurbulentSubArray obj = new LC978LongestTurbulentSubArray();
        int[] arr = { 9, 9 };
        System.out.println(obj.maxTurbulenceSize(arr));
        String s = "";
        s.split(" ");
    }

}
