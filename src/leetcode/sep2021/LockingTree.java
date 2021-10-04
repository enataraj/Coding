package leetcode.sep2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LockingTree {
    Map<Integer, Integer> lock = new HashMap<>();
    int[] parent;
    boolean decendentsLock = false;

    public LockingTree(int[] parent) {
        this.parent = parent;
    }

    public boolean lock(int num, int user) {
        if (lock.containsKey(num)) {
            return false;
        }
        lock.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lock.containsKey(num) && user == lock.get(num)) {
            lock.remove(num);
            return true;
        }
        return false;

    }

    public boolean upgrade(int num, int user) {
      
        if (!lock.containsKey(num)) {
            

        }
        return false;
    }

    private boolean findDecententIsLocked(int[] parent, int num) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[parent.length];
        queue.add(num);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNum = queue.poll();
                if (lock.containsKey(curNum)) {
                    return true;
                }
                visited[curNum] = true;
                for (int j = 0; j < parent.length; j++) {
                    if (parent[j] == curNum && !visited[j]) {
                        queue.add(j);
                    }
                }

            }

        }
        return false;
    }
    
    
    class LockingTree1 {
        int[] parent;
        ArrayList<Integer>[] tree;
        HashMap<Integer, Integer> locked; // node, user.
        public LockingTree1(int[] parent) {
            int n = parent.length;
            tree = new ArrayList[n];
            locked = new HashMap<Integer, Integer>();
            
            this.parent = parent;
            
            for(int i=0; i<n ;i++){
                tree[i] = new ArrayList<Integer>();
            }
            
            for(int i=1; i<n; i++){
                tree[parent[i]].add(i);
            }
        }
        
        public boolean lock(int num, int user) {
            if(locked.containsKey(num)) return false;
            locked.put(num, user);
            return true;
        }
        
        public boolean unlock(int num, int user) {
            if(!locked.containsKey(num) || locked.get(num)!=user) return  false;
            locked.remove(num, user);
            return true;
        }
        
        public boolean upgrade(int num, int user) {
            
            if(locked.containsKey(num)) return false;
            
            // if current node has any decendant that is locked.
            boolean hasDecendant = dfs(num, new HashSet<Integer>());
            if(hasDecendant==false) return false;
            
            // check if all the ancestor nodes are unlocked.
            int curr = num;
            while(curr!=-1){
                curr = parent[curr];
                if(locked.containsKey(curr))
                    return false;
            }
            
            // unlock all decendants and lock current node.
            unlock(num, user, new HashSet<Integer>());
            locked.put(num, user);
            return true;
            
        }
        public boolean unlock(int src, int user, HashSet<Integer> visited){
            /* unlocks all the decendants of 'src' */
            if(locked.containsKey(src) ){
                locked.remove(src);
            }
            if(visited.contains(src)) {
                return false;
            }
            
            visited.add(src);
            for(int nbr : tree[src]){
                if(unlock(nbr, user, visited)) 
                    return true;
            }
            return false;
        }

        public boolean dfs(int src, HashSet<Integer> visited){
            /* checks if any decendant of 'src' is locked, if yes, then returns true. */
            if(locked.containsKey(src)) {
                return true;
            }
            if(visited.contains(src)){
                return false;
            }
            visited.add(src);
            
            for(int nbr : tree[src]){
                if(dfs(nbr, visited))  return true;
            }
            return false;
        }
    }
}
