package leetcode.sep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        StringBuffer buf = new StringBuffer();

        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        Set<Integer> exIdxSet = new HashSet<>();
        for (int i = 0; i < secret.length(); i++) {
            char sch = secret.charAt(i);
            char gch = guess.charAt(i);
            if (sch == gch) {
                bulls++;
            } else {

                if (idxMap.containsKey(sch)) {

                    idxMap.put(sch, idxMap.get(sch) + 1);
                } else {

                    idxMap.put(sch, 1);
                }
                exIdxSet.add(i);
            }
        }

        for (int idx : exIdxSet) {
            char ch = guess.charAt(idx);
            if (idxMap.containsKey(ch)) {
                cows++;
                int count = idxMap.get(ch);
                count--;
                if (count == 0) {
                    idxMap.remove(ch);

                } else {
                    idxMap.put(ch, count);
                }
            }

        }

        buf.append(bulls + "A");
        buf.append(cows + "B");
        return buf.toString();

    }

    public static void main(String[] args) {
        BullsAndCows obj = new BullsAndCows();
       // String secret = "1807";
        //String guess = "7810";
        String secret = "1123";
        String guess = "0111";
        System.out.println(obj.getHint(secret, guess));

    }

}
