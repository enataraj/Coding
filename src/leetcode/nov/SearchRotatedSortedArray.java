package leetcode.nov;

public class SearchRotatedSortedArray {

    /*
     * public boolean search(int[] nums, int target) { if (nums == null ||
     * nums.length == 0) { return false; }
     * 
     * int length = nums.length - 1;
     * 
     * 
     * return false; }
     */

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int length = nums.length - 1;
        if (nums[0] < nums[length]) {
            return binarySearchHelpher(nums, target, 0, length);
        }

        int pivot = findPivot(nums);
        System.out.println(pivot);
        System.out.println("Pivot : " + pivot + "  Value : " + nums[pivot]);
        if (pivot == -1) {
            return binarySearchHelpher(nums, target, 0, length);
        } else if (target >= nums[0] && target <= nums[pivot]) {
            return binarySearchHelpher(nums, target, 0, pivot);
        } else if (target > nums[pivot] && target <= nums[length]) {
            return binarySearchHelpher(nums, target, pivot, length);
        }

        return false;

    }

    private int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == nums[end]) {
                start += 1;
                end -= 1;

            } else {
                int mid = start + (end - start) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[start] >nums[mid]) {
                    end = mid;
                } else if (nums[mid] > nums[end]) {
                    start = mid;
                }else {
                    start+=1;
                }

            }

        }

        return -1;

    }

    public boolean search_sol(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[low] == nums[high] && nums[low] == nums[mid]) {
                low++;
                high--;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target <= nums[high] && target > nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
    
    public boolean search_leet(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[low]) {
                low++;
            } else if(nums[mid] > nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return false;
    }



    private boolean binarySearchHelpher(int[] nums, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(obj.search(nums, target));
    }

}
