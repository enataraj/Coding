package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PerfectSquare {

	public int numSquares(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return helper(n, cache);
    }
    
    private int helper(int n, Map<Integer, Integer> cache) {
        if (n <= 1) {
            return n;
        } else if (cache.containsKey(n)) {
            return cache.get(n);   
        }
        
        double sqrt = Math.sqrt(n);
        if (sqrt - (int) sqrt == 0.0) {
            return 1; // perfect square
        }
        
        int res = n;
        for (long i = 2; i*i <= (long) n; i++) {
            res = Math.min(res, 1 + helper(n - (int) (i*i), cache));
        }
        
        cache.put(n, res);
        return res;
        
    }
	

	public int numSquaresDP(int n) {

		int[] arr = new int[n + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; (j * j) <= i; j++) {
				arr[i] = Math.min(arr[i], arr[i - (j * j)] + 1);
			}
		}

		return arr[n];
	}

	public static void main(String[] args) {
		PerfectSquare obj = new PerfectSquare();
		int n = 20;
		for (int i = 1; i <= n; i++) {
			int result = obj.numSquares(i);
			System.out.println("Perfect Square for N " + i);
			System.out.println(result);
		}

	}

}
