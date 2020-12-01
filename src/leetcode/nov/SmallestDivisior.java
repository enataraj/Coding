package leetcode.nov;

public class SmallestDivisior {

    
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 0, hi = (int) 1e6;
        while (hi > lo + 1) {
            int mid = lo + (hi - lo) / 2;
            if (ok(nums, mid, threshold)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    //Is sum of each 'num / mid' not greater than threshold?
    //FFFFF'T'TTTTTT
    private boolean ok(int[] nums, int mid, int threshold) {
        int res = 0;
        for (int n : nums) {
            res += (n + mid - 1) / mid;
        }
        return res <= threshold;
    }
    
    
    public int smallestDivisor_app1(int[] nums, int threshold) {
        int max = nums[0];
        for(int num : nums){
            max = Math.max(num, max);
        }
        int left = 1;
        int right = max;
        while(left < right){
            int mid = left + (right - left)/2;
            int res = 0;
            for(int num : nums){
                res += (num + mid - 1) / mid;
            }
            if(res <= threshold){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    
    
    public int smallestDivisorParin(int[] nums, int threshold) {
        int low = 1,
            high = getMax(nums);
        
        while (low < high) {
            int mid = low + (high - low) / 2,
                divisionSum = getDivisionSum(nums, mid);
            
            if (divisionSum <= threshold) {
                high = mid;
                
            } else {
                low = mid + 1;
                
            }
        }
        
        return low;
    }
    
    private int getDivisionSum(int[] nums, int divisor) {
        int divisionSum = 0;
        
        for (int num: nums) {
            divisionSum += (int) Math.ceil((double) num / (double) divisor);
        }
        
        return divisionSum;
    }
    
    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }        
        return max;
    }
    
    
    
}
