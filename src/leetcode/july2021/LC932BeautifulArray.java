package leetcode.july2021;

import java.util.ArrayList;
import java.util.List;

public class LC932BeautifulArray {
    public int[] beautifulArray(int n) {

        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);

        for (int i = 2; i <= n; i++) {
            List<Integer> curList = new ArrayList<>();

            for (int num : resultList) {
                int curVal = num * 2 - 1;
                if (curVal <= i) {
                    curList.add(curVal);
                }
            }

            for (int num : resultList) {
                int curVal = num * 2;
                if (curVal <= i) {
                    curList.add(curVal);
                }
            }
            resultList = curList;

        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }

}
