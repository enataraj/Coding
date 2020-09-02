package leetcode.aug;

import java.util.Arrays;

public class NumberWIthSameConsequtive {

    public int[] numsSameConsecDiff(int N, int K) {

        int result[] = new int[2];
        int num=0;

        for (int j = 1; j <= 9; j++) {
            for (int i = 0; i < N; i++) {
                
                num = j+(i*K);
                if(num>9) {
                    break;
                }

                System.out.print(num);
            }
            System.out.print(num);
            System.out.println();
        }

        return result;

    }

    public static void main(String[] args) {
        NumberWIthSameConsequtive obj = new NumberWIthSameConsequtive();

        int N = 4;
        int K = 3;

        int[] result = obj.numsSameConsecDiff(N, K);
        System.out.println(Arrays.toString(result));

    }

}
