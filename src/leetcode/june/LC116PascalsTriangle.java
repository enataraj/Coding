package leetcode.june;

import java.util.ArrayList;
import java.util.List;

public class LC116PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        numRows = numRows - 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        result.add(rowList);
        for (int row = 1; row <= numRows; row++) {
            rowList = new ArrayList<>();
            rowList.add(1);
            for (int i = 1; i < row; i++) {
                rowList.add(result.get(row - 1).get(i - 1) + result.get(row - 1).get(i));
            }
            rowList.add(1);
            result.add(rowList);
        }
        return result;
    }
    
    
    public List<List<Integer>> generateClean(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> tempList = new ArrayList<Integer>();
            for (int element = 0; element < row + 1; element++) {
                if (element == 0 || row == element)
                    tempList.add(1);
                else
                    tempList.add(result.get(row - 1).get(element - 1) + result.get(row - 1).get(element));
            }
            result.add(tempList);
        }
        return result;
    }
    
    public static void main(String[] args) {
        LC116PascalsTriangle obj = new LC116PascalsTriangle();
        System.out.println(obj.generate(5));
        
    }

}
