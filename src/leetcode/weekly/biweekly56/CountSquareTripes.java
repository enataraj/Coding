package leetcode.weekly.biweekly56;

import java.util.HashSet;
import java.util.Set;

public class CountSquareTripes {

    public int countTriples(int n) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <=n; i++) {
            set.add(i * i);

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    if (set.contains(((i * i) + (j * j)))) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        CountSquareTripes obj = new CountSquareTripes();
        System.out.println(obj.countTriples(10));
    }

}
