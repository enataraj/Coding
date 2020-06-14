package general;

import java.util.ArrayList;
import java.util.List;

public class MaxCandies {
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies =0;
        List<Boolean> resList = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(maxCandies <candies[i]){
                maxCandies = candies[i];
            
            }
        }
        
         for(int i=0;i<candies.length;i++){
             if(maxCandies <= candies[i]+extraCandies){
              resList.add(true);
             }else{
                 resList.add(false);
             }
            }
        return resList;
    }

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> result = new MaxCandies().kidsWithCandies(candies, extraCandies);
        System.out.println(result);
        
    }
}
