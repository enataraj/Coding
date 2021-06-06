class NumArray {

    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i-1]+nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        if(left==right){
            return nums[left];
        }
        if(left==0){
            return nums[right];
        }
        return nums[right] - nums[left-1];
        
    }
}
