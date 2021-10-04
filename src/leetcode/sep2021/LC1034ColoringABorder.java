package leetcode.sep2021;

import java.util.Arrays;

public class LC1034ColoringABorder {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid,r0,c0,grid[r0][c0],color,grid.length,grid[0].length,visited);        
        return grid;
    }
    
    private void dfs(int[][] grid,int row,int col,int color,int new_color,int rows,int cols,boolean[][] visited){
       if(!isValid(row,col,rows,cols) || visited[row][col] || grid[row][col] != color){
            return;
       }
     
        visited[row][col] = true;
        
        if(row == 0 || col == 0 || row == rows-1 || col == cols-1 || differentComponentNeighbours(grid,row,col,rows,cols,visited,color)){
            grid[row][col] = new_color;
        }
        
        dfs(grid,row-1,col,color,new_color,rows,cols,visited);
        dfs(grid,row+1,col,color,new_color,rows,cols,visited);
        dfs(grid,row,col-1,color,new_color,rows,cols,visited);
        dfs(grid,row,col+1,color,new_color,rows,cols,visited);
    }
    
    private boolean differentComponentNeighbours(int[][] grid,int row,int col,int rows,int cols,boolean[][] visited,int color){
        if(isValid(row-1,col,rows,cols) && !visited[row-1][col] && grid[row-1][col] != color) return true;
        if(isValid(row+1,col,rows,cols) && !visited[row+1][col] && grid[row+1][col] != color) return true;
        if(isValid(row,col-1,rows,cols) && !visited[row][col-1] && grid[row][col-1] != color) return true;
        if(isValid(row,col+1,rows,cols) && !visited[row][col+1] && grid[row][col+1] != color) return true;
        return false;
    }
    
    private boolean isValid(int row,int col,int rows,int cols){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    
    
    
    
    
    
    
    
    
    private boolean isDiognalValid(int row, int col, boolean[][] visited) {
        if (row >= 1 && col >= 1 && row < visited.length - 1 && col < visited[0].length - 1 && visited[row - 1][col - 1]
                && visited[row - 1][col + 1] && visited[row + 1][col - 1] && visited[row + 1][col + 1]) {
            return true;
        }
        return false;
    }

    private boolean isDiognalValidbkp(int[][] grid, int row, int col, int oldColor, int newColor) {
        if (row >= 1 && col >= 1 && row < grid.length - 1 && col < grid[0].length - 1
                && (grid[row - 1][col - 1] == oldColor || grid[row - 1][col - 1] == newColor)
                && (grid[row - 1][col + 1] == oldColor || grid[row - 1][col + 1] == newColor)
                && (grid[row + 1][col - 1] == oldColor || grid[row + 1][col - 1] == newColor)
                && (grid[row + 1][col + 1] == oldColor || grid[row + 1][col + 1] == newColor)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC1034ColoringABorder obj = new LC1034ColoringABorder();
        int[][] grid = { { 1, 2, 1, 2, 1, 2 }, { 2, 2, 2, 2, 1, 2 }, { 1, 2, 2, 2, 1, 2 } };
        int row = 1;
        int col = 3;
        int color = 1;
        int[][] g = obj.colorBorder(grid, row, col, color);
        for (int i = 0; i < g.length; i++) {
            System.out.println(Arrays.toString(g[i]));
        }
    }

}

/*
 * 
 * 
 * [[1,2,1,2,1,2],
 *  [2,2,2,--2,1,2],
 *  [1,2,2,2,1,2]]
 *  
 *  my o/p
 *  
 *  [[1,1,1,1,1,2],
 *   [1,1,2,1,1,2],
 *   [1,1,1,1,1,2]]
 *   
 *   Expected
 *   [[1,1,1,1,1,2],
 *   [1,2,1,1,1,2],
 *   [1,1,1,1,1,2]]
 *  
 * 
 * 
 * 
 * 
 */
