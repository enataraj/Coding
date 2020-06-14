package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

    Set<Integer> hashset;
    Random ran;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashset = new HashSet<>();
        ran = new Random();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        boolean flag = hashset.add(val);
        if (flag) {
            list.add(val);
        }
        return flag;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        boolean flag = hashset.remove(val);
        if (flag) {
            list.remove((Integer)val);
        }
        return flag;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        return list.get(ran.nextInt(hashset.size() ));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());

    }

}
