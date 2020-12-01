package leetcode;

public class LC1089DuplicateZero {
    
public void duplicateZeros(int[] arr) {
    if(arr==null || arr.length<=1){
        return;
    }
    
    int numberOfZero = 0;
    int length = arr.length;
    
    for(int i=0;i<length;i++) {
        if(arr[i]==0) {
            numberOfZero++;
        }
    }
    if(numberOfZero==0) {
        return;
    }
    
    if(arr[length-numberOfZero-1] == 0) {
        arr[length-1] = 0;
        numberOfZero--;
        
    }
}
    
    
    public static void main(String[] args) {
        LC1089DuplicateZero obj = new LC1089DuplicateZero();
        int[] nums = {1,0,2,3,0,4,5,0};
        obj.duplicateZeros(nums);
        
    }

}
