package leetcode.april;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC554BrickWall {
    
    
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for(List<Integer> list: wall){
            int sum = 0;
            for(int i = 0; i < list.size()-1; i++){
                sum += list.get(i);
                count.put(sum, count.getOrDefault(sum, 0)+1);
            }
        }
        
        int max = 0;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        
        return wall.size()-max;
        
    }
    
    
    
    // Memory Limit Exceeded
    public int leastBricksMLE(List<List<Integer>> wall) {
        int col = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            col += wall.get(0).get(i);

        }
        int row = wall.size();
        boolean[][] wallmatrix = new boolean[row][col + 1];
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                sum += wall.get(i).get(j);
                wallmatrix[i][sum] = true;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                if (!wallmatrix[j][i]) {
                    sum += 1;
                }

            }
            minSum = Math.min(minSum, sum);
        }

        return minSum;

    }

}
