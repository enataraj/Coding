package leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC1380LuckyNumber {
public List<Integer> luckyNumbers (int[][] matrix) {
    
    int[] rowMin = new int[matrix.length];
    int[] colMax =  new int[matrix[0].length];
   
    int min = Integer.MAX_VALUE;
    for(int i=0;i<matrix.length;i++) {
        min = Integer.MAX_VALUE;
        for(int j=0;j<matrix[i].length;j++) {
            min = Math.min(min, matrix[i][j]);
        }
        rowMin[i] = min;
        
        
    }
    
    int max;
    for(int i=0;i<matrix[0].length;i++) {
        max = Integer.MIN_VALUE;
        for(int j=0;j<matrix.length;j++) {
            max = Math.max(min, matrix[j][i]);
        }
        colMax[i] = max;
        
        
    }
    
    System.out.println(Arrays.toString(rowMin));
    System.out.println(Arrays.toString(colMax));
    return Collections.EMPTY_LIST;
        
    }
    
    public static void main(String[] args) {
        LC1380LuckyNumber obj = new LC1380LuckyNumber();
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(obj.luckyNumbers(matrix));
        
    }

}
