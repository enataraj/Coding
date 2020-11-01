package leetcode.oct;

public class ChambingeTower {
    
    
    public double champagneTowerDP(int poured, int query_row, int query_glass) {
        double[][] cache = new double[101][101];
        cache[0][0] = poured;
        
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                double overflow = (cache[i][j] - 1.0) / 2.0;
                if (overflow > 0.0) {
                    cache[i+1][j] += overflow;
                    cache[i+1][j+1] += overflow;
                }
            }
        }
        
        return cache[query_row][query_glass] >= 1.0 ? 1.0 : cache[query_row][query_glass];
    }   
    
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][]tower = new double[1 + query_row][1 + query_row];
        tower[0][0] = (double)poured;
        for(int i = 0;i<query_row;i++)
        {
            for(int j = 0; j<=i;j++)
            {
                if(tower[i][j]>1){
                    tower[i+1][j] += (tower[i][j]-1)/2.0;
                    tower[i+1][j+1] += (tower[i][j]-1)/2.0;
                    tower[i][j] = 1;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }

}
