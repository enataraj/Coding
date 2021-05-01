package leetcode.april;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC341NestedIterator {

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        List<NestedInteger> nestedList;
        List<Integer> list;
        Iterator<Integer> itr;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            list = new ArrayList<>();
            extractList(nestedList);
            itr = list.iterator();
        }

        @Override
        public Integer next() {
            return itr.next();

        }

        @Override
        public boolean hasNext() {
            return itr.hasNext();

        }

        private void extractList(List<NestedInteger> nestedList) {
            for (int i = 0; i < nestedList.size(); i++) {
                if (nestedList.get(i).isInteger()) {
                    list.add(nestedList.get(i).getInteger());
                } else {
                    extractList(nestedList.get(i).getList());
                }
            }
        }
    }
}
