package leetcode.sep2021;

public class LC740DeleteAndEarn {
    
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        int max = 0;
       for(int num:nums){
           values[num]+=num;
           max = Math.max(num,max);
                         
       }       
        int pick =0;int notPick =0;       
        for(int i=0;i<=max;i++){
            int picki = notPick+values[i];
            int notPicki = Math.max(pick,notPick);
            pick = picki;
            notPick = notPicki;
        }
        return Math.max(pick,notPick);
    }
    
    public int deleteAndEarn_houseRob(int[] nums) {
        int[] values = new int[10001];
        int max=0;
         for(int num:nums){
           values[num]+=num;
           max = Math.max(num,max);
                         
       }       
        int result[] = new int[10001];
        result[0] = values[0];
        result[1] = Math.max(values[0],values[1]);
        for(int i=2;i<=max;i++){
            result[i] = Math.max(result[i-2]+values[i],  result[i-1]);
        }
        return result[max];
    }
    
    

}
