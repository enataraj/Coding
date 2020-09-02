package leetcode.aug;

public class CombinationIterator {

    int[] indices; // 
    int k, n;
    boolean isNextSet; 
    char[] arr;
    
    public CombinationIterator(String characters, int combinationLength) { // ["abcdef", 4]
        this.k = combinationLength; // 4
        this.n = characters.length(); // 6
        indices = new int[k]; // [0,1,2,3]
        isNextSet = true; // false
        arr = characters.toCharArray(); // [a, b, c, d, e, f]
        
        for (int i = 0; i < k; i++) {
            indices[i] = Math.min(i, n - (k-i));
        }
    }
    
    public String next() {
        if (!isNextSet) {
            setNext();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(arr[indices[i]]);
        }
        
        isNextSet = false;
        return sb.toString();
    }
    
    public boolean hasNext() {
        if (isNextSet) {
            return true;
        }
        
        return setNext();
    }
    
    private boolean setNext() {
        for (int i = k-1; i >= 0; i--) { // i = 1
            if (indices[i] < n - (k - i)) {
                ++indices[i];
                for (int j = i+1; j < k; j++) {
                    indices[j] = indices[j-1] + 1;
                }
                isNextSet = true;
                return true;
            }
        }
        
        return false;
    }
}