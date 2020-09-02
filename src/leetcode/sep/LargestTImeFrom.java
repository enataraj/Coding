package leetcode.sep;

import java.util.Arrays;

public class LargestTImeFrom {

    public String largestTimeFromDigits(int[] A) {
        String largest = "";
        int largestMinutes = 0;
        int[] digits = new int[10];
        for (int d : A) {
            ++digits[d];
        }

        for (int i = 24 * 60 - 1; i >= 0; i--) {
            int hours = i / 60, minutes = i % 60;

            String hs = (hours < 10) ? ("0" + hours) : (hours + "");
            String ms = (minutes < 10) ? ("0" + minutes) : (minutes + "");

            if (containsAllDigits(hs, ms, digits)) {
                return hs + ":" + ms;
            }
        }

        return "";
    }

    private boolean containsAllDigits(String hs, String ms, int[] digits) {
        int[] digitsCopy = Arrays.copyOf(digits, 10);

        for (int i = 0; i < hs.length(); i++) {
            int d = hs.charAt(i) - '0';
            --digitsCopy[d];

            if (digitsCopy[d] < 0) {
                return false;
            }
        }

        for (int i = 0; i < ms.length(); i++) {
            int d = ms.charAt(i) - '0';
            --digitsCopy[d];

            if (digitsCopy[d] < 0) {
                return false;
            }
        }

        return true;
    }

    private int[] result;

    public String largestTimeFromDigitsPeru(int[] nums) {
        permutate(nums, 0);
        return format(result);
    }

    private void permutate(int[] nums, int offset) {
        if (offset == nums.length - 1) {
            if (isValid(nums) && isBetter(result, nums)) {
                if (result == null) {
                    result = new int[4];
                }
                for (int i = 0; i < 4; i++) {
                    result[i] = nums[i];
                }
            }
            return;
        }

        for (int i = offset; i < nums.length; i++) {
            int tmp = nums[offset];
            nums[offset] = nums[i];
            nums[i] = tmp;
            permutate(nums, offset + 1);
            nums[i] = nums[offset];
            nums[offset] = tmp;
        }

    }

    private boolean isValid(int[] nums) {
        return nums[0] <= 2 && (nums[0] == 2 ? nums[1] <= 3 : true) && nums[2] <= 5;

    }

    private boolean isBetter(int[] result, int[] nums) {
        if (result == null) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (result[i] == nums[i]) {
                continue;
            }
            if (result[i] < nums[i]) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private String format(int[] nums) {
        if (nums == null) {
            return "";
        } else {
            return new StringBuilder().append(nums[0]).append(nums[1]).append(':').append(nums[2]).append(nums[3])
                    .toString();
        }
    }
    
    
    
    // Backtracking
    
    
    void backtrack(int[] A, String tmp, String result) {
        if(tmp.length() == 2) {
            // validate the hours
            if(stoi(tmp) >= 24)
                return;
            else
                tmp += ":";            
        }
        if(tmp.length() == 5) {
            // validate the minutes
            if(stoi(tmp.substr(3)) >= 60)
                return;
            if(result.empty()) {
                result = tmp;
            } else {
                // compare current time with previously stored
                int currTime = stoi(tmp.substr(0, 2)) * 60 + stoi(tmp.substr(3, 2));
                int resultTime = stoi(result.substr(0, 2)) * 60 + stoi(result.substr(3, 2));
                if(resultTime < currTime)
                    result = tmp;
            }
            return;
        }
        for(int i=0;i<A.size();i++) {
            if(A[i] == -1)
                continue;
            int stored = A[i];
            A[i] = -1;
            backtrack(A, tmp + to_string(stored), result);
            A[i] = stored;
        }
    }
   public String largestTimeFromDigits(int[] A) {
        String result = "";
        backtrack(A, "", result);
        return result;
    }

}
