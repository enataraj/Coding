package leetcode.matrix.dp;

public class DuengeonGame {
    
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length,
            cols = dungeon[0].length;
        
        int[][] dp = new int[rows][cols];
        
        for (int i = rows-1; i >= 0; i--) { // i = 1
            for (int j = cols-1; j >= 0; j--) { // j = 2
                if (i == rows-1 && j == cols-1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                    
                } else if (i == rows-1) {
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                    
                } else if (j == cols-1) {
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                    
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j]);
                    
                }
            }
        }
        
        return dp[0][0];
    }
    
    

}
