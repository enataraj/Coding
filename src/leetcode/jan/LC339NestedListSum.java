package leetcode.jan;

import java.util.ArrayList;
import java.util.List;

public class LC339NestedListSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int curDepth) {
        if (nestedList.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                total += (ni.getInteger() * curDepth);

            } else {
                total += helper(ni.getList(), curDepth + 1);

            }
        }

        return total;
    }

    class NestedInteger {
        private boolean isInteger() {
            return true;
        }

        private List<NestedInteger> getList() {
            List list = new ArrayList<>();
            return list;
        }

        private int getInteger() {
            return 0;
        }

    }

    public static void main(String[] args) {
        LC339NestedListSum obj = new LC339NestedListSum();

    }

}
