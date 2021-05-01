package leetcode.topint;

import java.util.ArrayList;
import java.util.List;

public class LC118Pascaltriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        result.add(list0);
        if (numRows == 1) {
            return result;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);

        result.add(list1);

        if (numRows == 2) {
            return result;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> tmpList = result.get(i - 1);
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for (int j = 1; j < tmpList.size(); j++) {
                curList.add(tmpList.get(j - 1) + tmpList.get(j));
            }
            curList.add(1);
            result.add(curList);
        }

        return result;

    }

    public List<List<Integer>> generateSol(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        LC118Pascaltriangle obj = new LC118Pascaltriangle();
        obj.generate(5);
    }

}
