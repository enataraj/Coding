package searching;

public class LC33SearchSortedRotateArray {
    
    
    public int searchSol(int[] A, int target) {
    int start = 0;
    int end = A.length-1;
    while(start<=end){
        int mid = start + (end-start)/2;
        if(A[mid] == target)
            return mid;
        if(A[start] < A[end]){  //both halves are sorted
            if(A[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        else if(A[mid] < A[end]){   //right half is sorted
            if(A[mid] < target && target <= A[end])
                start = mid+1;
            else
                end = mid-1;
        }
        else{   //left half is sorted
            if(A[start] <= target && target < A[mid])
                end = mid-1;
            else
                start = mid+1;
        }
    }
    return -1;

    }

    public int search(int[] nums, int target) {

        int pivot = findPivotIdx(nums, target);
        System.out.println(pivot);
        if (nums[pivot] == target) {
            return pivot;
        }

        if (pivot == 0 || target < nums[0]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }

        return binarySearch(nums, 0, pivot - 1, target);

    }

    private int binarySearch(int nums[], int left, int right, int target) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return -1;
    }

    private int findPivotIdx(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

       

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid == 0 || nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        LC33SearchSortedRotateArray obj = new LC33SearchSortedRotateArray();
        int[] nums = {3,1};
        System.out.println(obj.search(nums, 1));
    }

}
