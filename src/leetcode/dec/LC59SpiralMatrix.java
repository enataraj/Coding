package leetcode.dec;

public class LC59SpiralMatrix {

     int count =0;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n ][n ];
        int len = matrix.length-1;
        
       // matrixfill(matrix,3,len-3);
        
      for(int i=0;i<=len/2;i++) {
        matrixfill(matrix,i,len-i);
        }
        
      //  printMatrix(matrix);
        return matrix;

    }
    
    private void matrixfill(int[][] matrix,int rowLimit,int colLimit) {
        for(int j=rowLimit;j<=colLimit;j++) {
            matrix[rowLimit][j] = ++count;
        }
        
        for(int i=rowLimit+1;i<=colLimit;i++ ) {
            matrix[i][colLimit] = ++count;
        }
        
        for(int j=colLimit-1;j>=rowLimit;j--) {
            matrix[colLimit][j] = ++count;
        }
        
        for(int i=colLimit-1;i>rowLimit;i--) {
            matrix[i][rowLimit] = ++count;
        }
        
        
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //System.out.print(i + "," + j +" ("+matrix[i][j]+")"+ "  ");
                System.out.print("("+matrix[i][j]+")"+ "  ");
            }
            System.out.println();
        }

    }
    
    
    public int[][] generateMatrixParin(int n) {
        int[][] res = new int[n][n], // [1,2,3,4] [0,0,0,0] [0,0,0,0] [0,0,0,0]
            dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int val = 1, // 5
            i = 0, // 0
            j = 0, // 3
            dirIdx = 0, // 1
            moves = n-1; // 3
        
        res[0][0] = val++;
        
        while (val <= n*n) {
            for (int c = 0; c < (moves == n-1 ? 3 : 2) && val <= n*n; c++) { // c = 1
                for (int m = 0; m < moves && val <= n*n; m++) { // m = 2
                    i += dirs[dirIdx][0];
                    j += dirs[dirIdx][1];
                    res[i][j] = val++;
                }
                
                dirIdx = (dirIdx + 1) % 4;
            }
            
            --moves;
        }
        
        return res;
        
    }

    public static void main(String[] args) {
        LC59SpiralMatrix obj = new LC59SpiralMatrix();
        obj.generateMatrix(7);

    }

}
