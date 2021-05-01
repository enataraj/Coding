package leetcode.april;

public class LC667BeautifulArrangementII {
    public int[] constructArray(int n, int k) {

        int[] ans = new int[n];
        int low = 1;
        int high = k + 1;
        for (int i = 0; i < k + 1; i++) {
            if (i % 2 == 0) {
                ans[i] = low;
                low++;
            } else {
                ans[i] = high;
                high--;
            }
        }
        for (int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
    
    public int[] constructArraySol(int n, int k) {
        int[] result = new int[n];
         int start = 1;
         int end = k + 1;
         int idx = 0;
         while(start < end) {
             result[idx++] = start++;
             result[idx++] = end--;
         }
         if(start == end) {
             result[idx++] = start;
         }
         
         for(int j = k + 2; j <= n; ++j) {
             result[idx++] = j;
         }
         
         return result; 
     }
    
    
    public int[] constructArraySol3(int n, int k) {
        boolean isLower = true;
        int[] result = new int[n];
        int start = 1;
        int end = n;
        int count = 0;
        int resultIndex = 0;
        while (count++ < (k - 1)) {
            if (isLower) {
                result[resultIndex++] = start;
                start += 1;
                isLower = !isLower;
            } else {
                result[resultIndex++] = end;
                end -= 1;
                isLower = !isLower;
            }
        }

        if (isLower)
            while (start <= end)
                result[resultIndex++] = start++;
        else
            while (start <= end)
                result[resultIndex++] = end--;

        return result;
    }

}
