package leetcode.march;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    Map<Integer,Integer> map = new HashMap<>();
    /*
     * int[] myMap;
     * 
     * public MyHashMap() { myMap = new int[1000000]; Arrays.fill(myMap, -1); }
     * 
     * 
     * myMap[key] = value; }
     * 
     * 
     * public int get(int key) { return myMap[key]; }
     * 
     * 
     * public void remove(int key) { myMap[key] = -1; }
     */

    private int[] myMap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        myMap = new int[100001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        myMap[key] = value + 1;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        return myMap[key] - 1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        myMap[key] = 0;
    }

}
