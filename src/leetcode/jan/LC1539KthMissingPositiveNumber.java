package leetcode.jan;

public class LC1539KthMissingPositiveNumber {
    
    public int findKthPositive(int[] arr, int k) {
        
        int prev = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > prev + k) return prev+k;
            k = k - (arr[i] - prev - 1);
            prev = arr[i];
        }
        return prev + k;
        
    }
    
    public int findKthPositiveAlt(int[] arr, int k) {
        int idx = 0, value = 1;
        while (idx < arr.length && k != 0) {
            if (arr[idx] == value) {
                idx++;
            } else {
                k--;
                if (k == 0) {
                    return value;
                }
            }
            value++;
        }
        return value + k - 1;
    }
    
    public static void main(String[] args) {
        LC1539KthMissingPositiveNumber obj = new LC1539KthMissingPositiveNumber();
        int[] arr = {2,3,4,7,11};
        int k=5;
        System.out.println(obj.findKthPositive(arr, k));
        
    }

}
