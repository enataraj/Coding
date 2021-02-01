package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC914XKindDesckCards {
    public boolean hasGroupsSizeX(int[] deck) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (freqMap.containsKey(deck[i])) {
                freqMap.put(deck[i], freqMap.get(deck[i]) + 1);
            } else {
                freqMap.put(deck[i], 1);
            }
        }
        System.out.println(freqMap);

        int div = Integer.MAX_VALUE;

        for (int val : freqMap.values()) {
            div = Math.min(div, val);
        }

        for (int i = 2; i <= div; i++) {
            int cnt = 0;
            for (int val : freqMap.values()) {
                if (val % i == 0) {
                    cnt++;
                }
            }
            if (cnt == freqMap.size()) {
                return true;
            }
        }

        return false;
    }

    public boolean hasGroupsSizeXSol(int[] deck) {
        int[] freq = new int[1001];
        int res = 0;
        for (int val : deck)
            freq[val]++;
        for (int val : freq) {
            if (val == 0)
                continue;
            if (res == 0)
                res = val;
            else
                res = hcf(res, val);
        }
        return res >= 2;
    }

    private int hcf(int small, int big) {
        if (small > big)
            return hcf(big, small);
        if (small == 0)
            return big;
        return hcf(big % small, small);
    }

    public static void main(String[] args) {
        LC914XKindDesckCards obj = new LC914XKindDesckCards();
        int[] deck = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
        System.out.println(obj.hasGroupsSizeX(deck));
    }

}
