package algorithm;

public class BinaryIndexTree {
    int[] BITree;

    /* 
     * 
     *  n --> No. of elements present in input array. 
        BITree[0..n] --> Array that represents Binary Indexed Tree.
                    
        arr[0..n-1] --> Input array for which prefix sum is evaluated. 
                    
        Returns sum of arr[0..index]. This function assumes that the array is preprocessed and 
        partial sums of array elements are stored in BITree[].
     
     * 
     * 
     */

    private int getSum(int index) {
        int sum = 0; // Iniialize result
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;
        // Traverse ancestors of BITree[index]
        while (index > 0) {
            // Add current element of BITree to Sum to sum
            sum += BITree[index];
            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }

    // Updates a node in Binary Index Tree (BITree) at given index in BITree. The given value 
    // 'val' is added to BITree[i] and all of its ancestors in tree.

    public void updateBIT(int n, int index, int val) {
        // index in BITree[] is 1 more than the index in arr[]

        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n) {
            // Add 'val' to current node of BIT Tree
            BITree[index] += val;
            // Update index to that of parent in update View
            index += index & (-index);
        }
    }

    private void constructBITree(int arr[], int n) {
        BITree = new int[arr.length];
        // Initialize BITree[] as 0
        for (int i = 1; i <= n; i++)
            BITree[i] = 0;

        // Store the actual values in BITree[] using update()

        for (int i = 0; i < n; i++)
            updateBIT(n, i, arr[i]);
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return getSum(j);
        return getSum(j) - getSum(i - 1);
    }

}
