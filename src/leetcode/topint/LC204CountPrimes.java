package leetcode.topint;

import java.util.Arrays;

/*
 * Sieve of Eratosthenes
 * 
 * Define a boolean array of n+1 size in order to generate all the prime till n.
 * 
 * Fill all the boolean elements as True at beginning
 * 
 * Iterate the loop from 2 to i*i<n basically sqrt(n) (because 0 and 1 is prime)
 * 
 * if the number is prime, loop the inner loop from i*i to n with increment of j+i ( Basically update the boolean array for all multiples of corresponding prime number as false.
 * 
 *  Go over prime number array and add the count.
 * 
 * 
 */
public class LC204CountPrimes {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    prime[i] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (prime[i]) {
                cnt++;
            }
        }
        return cnt;
    }

}
