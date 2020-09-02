package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<Integer>();

        if (rowIndex == 0) {
            result.add(1);
            return result;

        }

        if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return result;
        }

   
        Integer[] tmpResult = new Integer[2];
        tmpResult[0] = 1;
        tmpResult[1] = 1;
        System.out.println(Arrays.toString(tmpResult));

        for (int i = 2; i <= rowIndex; i++) {

            result = new ArrayList<Integer>();
            result = Arrays.asList(tmpResult);
            int size = result.size();
            tmpResult = new Integer[size + 1];
            tmpResult[0] = result.get(0);
            tmpResult[size] = result.get(size - 1);
            int j = 1;
            int k = size - 1;
            while (j <= k) {
                tmpResult[j] = result.get(j - 1) + result.get(j);
                tmpResult[k] = result.get(k) + result.get(k - 1);
                j++;
                k--;
            }

           

        }
        System.out.println(Arrays.toString(tmpResult));

        return Arrays.asList(tmpResult);

    }
    
    
    public List<Integer> getRowOpt(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0)return res;
        for(int i = 1; i <= rowIndex; i++){
            long num = ((long)res.get(i-1)*(long)(rowIndex-i+1))/i;
            res.add((int)num);
        }
        return res;
    }
    

    public static void main(String[] args) {

        PascalTriangle obj = new PascalTriangle();
        System.out.println(obj.getRow(33));

    }

}
