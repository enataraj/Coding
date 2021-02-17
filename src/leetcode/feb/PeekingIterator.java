package leetcode.feb;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null) {
            next = iterator.next();
        }

        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = null;
        if (next != null) {
            res = next;
            next = null;

        } else {
            res = iterator.next();

        }

        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null || iterator.hasNext();
    }
    
    
    

}
