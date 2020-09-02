package leetcode.aug;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LargestCommonFactor {
  
        class UnionFind {
            int[] id;
            int[] rank;
            UnionFind(int n) {
                id = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    rank[i] = 1;
                }
            }
            
            int find(int p) {
                while (id[p] != p) {
                    id[p] = id[id[p]];
                    p = id[p];
                }
                return p;
            }
            
            void union(int p, int q) {
                p = find(p);
                q = find(q);
                if (p == q) {
                    return;
                } else if (rank[p] < rank[q]) {
                    id[q] = p;
                    rank[p] += rank[q];
                } else {
                    id[p] = q;
                    rank[q] += rank[p];
                }
            }
            
            int getRank(int i) {
                return rank[find(i)];
            }
        }
        
        Set<Integer> getPrimeFactors(int val) {
            HashSet<Integer> set = new HashSet<>();
            
            while (val % 2 == 0) {
                set.add(2);
                val /= 2;
            }
            
            
            for (int i = 3; i * i <= val; i += 2) {
                while (val % i == 0) {
                    set.add(i);
                    val /= i;
                }
            }
            
            if (val > 1) {
                set.add(val);
            }
            return set;
        }
        public int largestComponentSize(int[] A) {
            HashMap<Integer, Integer> first = new HashMap<>();
            UnionFind uf = new UnionFind(A.length);
            
            for (int i = 0; i < A.length; i++) {
                for (int p : getPrimeFactors(A[i])) {
                    if (!first.containsKey(p)) {
                        first.put(p, i);
                    } else {
                        uf.union(first.get(p), i);
                    }
                }
            }
            
            int max = 0;
            for (int i = 0; i < A.length; i++) {
                max = Math.max(uf.getRank(i), max);
            }
            
            return max;
        }
    
   


}
