package general;

public class BinarySearchLeftBound {
    
    private int binarySearch(int[] nums) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (1 == nums[mid]) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }       
        if(lo==nums.length) {
            return -1;
        }
        return lo;
    }
    
    public static void main(String[] args) {
        BinarySearchLeftBound obj = new BinarySearchLeftBound();
        int[] nums = {0,1,1};
        int[] nums1 = {0,0,0};
        System.out.println(obj.binarySearch(nums));
        System.out.println(obj.binarySearch(nums1));
        
        
    }


}
