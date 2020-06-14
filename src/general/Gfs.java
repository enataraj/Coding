package general;

public class Gfs {
    
    /* The main function that returns the number of ways to get sum 'x' with 'n' dice and 'm' with m faces. */
    public static long findWays(int face, int dice, int sum){ 
          
    /* Create a table to store the results of subproblems.  
    One extra row and column are used for simplicity  
    (Number of dice is directly used as row index and sum is directly used as column index).  
    The entries in 0th row and 0th column are never used. */
    long[][] table = new long[dice+1][sum+1]; 
          
    /* Table entries for only one dice */
    for(int j = 1; j <= face&& j <= sum; j++) 
                table[1][j] = 1; 
              
    /* Fill rest of the entries in table using recursive relation  
    i: number of dice, j: sum */
    for(int i = 2; i <= dice;i ++){ 
                for(int j = 1; j <= sum; j++){ 
                    for(int k = 1; k < j && k <= face; k++) 
                        table[i][j] += table[i-1][j-k]; 
                } 
        } 
          
       // Uncomment these lines to see content of table  
        for(int i = 0; i< dice+1; i++){ 
            for(int j = 0; j< sum+1; j++) 
                System.out.print(table[i][j] + " "); 
            System.out.println(); 
        } 
          
        return table[dice][sum]; 
    } 
    
    // Driver Code 
    public static void main (String[] args) { 
       
        System.out.println(" h "+findWays(6, 3, 5));  
         
    } 

}
