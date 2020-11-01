package leetcode;

import java.util.Arrays;

public class SumZero1304 {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 0;
            return res;
        }
       
        if (n % 2 != 0) {
            res[n - 1] = 0;
            n = n - 1;

        }

        for (int i = 1; i <= n / 2; i++) {
            res[i - 1] = i;
            res[n - i] = i * -1;

        }
        return res;

    }
    
    public int[] sumZeroDiff(int n) {
        int[]arr = new int[n];
        int len=n-1;
        int i=0;
       while(i<len){
           arr[i]=(i+1)-n;
           arr[len]=n-(i+1);
           i++;
           len--;
       }
        return arr;
    }

    public static void main(String[] args) {
        SumZero1304 obj = new SumZero1304();
        int n = 4;
        int[] res = obj.sumZero(n);
        System.out.println(Arrays.toString(res));

    }

}
