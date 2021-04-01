package leetcode.march;

import java.util.HashSet;
import java.util.Set;

public class LC575DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandyType = new HashSet<>();
        int caneat = candyType.length / 2;
        for (int type : candyType) {
            uniqueCandyType.add(type);
            if (uniqueCandyType.size() >= caneat) {
                return caneat;
            }

        }
        return uniqueCandyType.size();
    }

    public static void main(String[] args) {
        LC575DistributeCandies obj = new LC575DistributeCandies();
    }
}
