package leetcode.aug;

public class MyHashSet {

    boolean[] hashmap;

    /** Initialize your data structure here. */
    public MyHashSet() {

        hashmap = new boolean[1000001];

    }

    public void add(int key) {
        if (hashmap[key]) {
            return;
        }
        hashmap[key] = true;

    }

    public void remove(int key) {
        if (!hashmap[key]) {
            return;
        }

        hashmap[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashmap[key];

    }
    
    public static void main(String[] args) {
       
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        System.out.println(hashSet.contains(1));   
        System.out.println(hashSet.contains(3));    
        hashSet.add(2);          
        System.out.println(hashSet.contains(2));   
        hashSet.remove(2);          
        System.out.println(hashSet.contains(2));  
    }

}
