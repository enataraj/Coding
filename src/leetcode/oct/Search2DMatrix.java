package leetcode.oct;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || (matrix.length==1 && matrix[0].length==0)) {
            return false;
        }
        
        // Only one element case
         if (matrix.length == 1 && matrix[0].length == 1) {
            if (target == matrix[0][0])
                return true;
            return false;
        }

        int rowLen = matrix.length - 1;
        int colLen = matrix[0].length - 1;
    
        // Single Row Case
        if (matrix.length == 1) {
            int nums[] = new int[colLen+1];
            for (int i = 0; i <=colLen; i++) {
                nums[i] = matrix[0][i];
            }

            if (binarySearchHelper(nums, target) != -1) {
                return true;
            }

        }
        
      // Single column case
        if (matrix[0].length == 1) {
            int nums[] = new int[rowLen+1];
            for (int i = 0; i <= rowLen; i++) {
                nums[i] = matrix[i][0];
            }

            if (binarySearchHelper(nums, target) != -1) {
                return true;
            }

        }

        // Find a row where the number can fall into.
        int row = -1;
        int col = -1;
        for (int i = 0; i <= rowLen; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][colLen]) {
                if (target == matrix[i][0] || matrix[i][colLen] == target) {
                    return true;
                }
                row = i;
                break;
            }
        }
        
  
        if (row == -1 && col == -1) {
            return false;
        }

        
        // Do Binary Search only on that row numbers.
        int[] nums = new int[colLen+1];
        for (int i = 0; i <= colLen; i++) {
            nums[i] = matrix[row][i];
        }

        if (binarySearchHelper(nums, target) != -1) {
            return true;
        }

        return false;
    }

    private int binarySearchHelper(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + end - start / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;

            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
         * 
         * 00,01,02,03 10,11,12,13 20,21,22,23 30,31,32,33
         * 
         * 
         */

        Search2DMatrix obj = new Search2DMatrix();
      //  int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
       // int[][] matrix = {{1,3}};
        int[][] matrix = {{1,1},{2,2}};
        int target = 2;
        System.out.println(obj.searchMatrix(matrix, target));

    }

}
