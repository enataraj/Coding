package leetcode.feb;

public class LC240SearchIn2Dmatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        if (target > matrix[row][col] || target < matrix[0][0])
            return false;

        // Find Potential Row and Apply Binary Search
        for (int i = 0; i <= row; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][col]) {
                if (binarySearchHelpher(target, matrix, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean binarySearchHelpher(int target, int[][] nums, int idx) {

        int low = 0;
        int high = nums[0].length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[idx][mid] == target) {
                return true;
            }
            if (nums[idx][mid] < target) {
                low = mid + 1;

            } else if (nums[idx][mid] > target) {
                high = mid - 1;
            }

        }
        return false;

    }

    /*
     * Start Right top Corner see previous col value is greater than target move
     * left Previous col values is smaller move down
     * 
     */

    public boolean searchMatrixSol(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int column = matrix[0].length - 1;
        int i = 0;
        while (i < matrix.length && column >= 0) {
            if (matrix[i][column] == target) {
                return true;
            } else if (matrix[i][column] > target) {
                column--;
            } else {
                i++;
            }
        }
        return false;
    }

    /*
     * Start Left Bottom Corner see previous row value is greater than target move
     * up Previous row values is smaller move right
     * 
     */
    public boolean searchMatrixParin(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length, i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;

            } else if (target > matrix[i][j]) {
                ++i;

            } else {
                --j;

            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC240SearchIn2Dmatrix obj = new LC240SearchIn2Dmatrix();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 27;
        System.out.println(obj.searchMatrix(matrix, target));

    }

}
