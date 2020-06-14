package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSetHashMap {

    Map<Integer, Integer> hashmap;
    Random ran;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSetHashMap() {
        hashmap = new HashMap<>();
        ran = new Random();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (hashmap.get(val) == null) {
            hashmap.put(val, list.size());
            list.add(val);
            return true;

        }
        return false;

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (hashmap.get(val) != null) {
            int lastIndex = hashmap.get(val);

            if (lastIndex < hashmap.size()) {
                int lastVal = list.get(list.size() - 1);
                hashmap.put(lastVal, lastIndex);
                list.set(lastIndex, lastVal);
            }

            hashmap.remove(val);
            list.remove(list.size() - 1);
            return true;

        }
        return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(ran.nextInt(hashmap.size()));
    }
    
    public static void main(String[] args) {
        RandomizedSetHashMap obj = new RandomizedSetHashMap();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());

    }

}
