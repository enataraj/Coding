package leetcode.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC936StampingSequence {
    public int[] movesToStamp(String stamp, String target) {
        if (stamp.length() > target.length()) {
            return new int[] {};
        }

        char[] targetCharArray = target.toCharArray();
        char[] stampCharArray = stamp.toCharArray();
        boolean[] visited = new boolean[targetCharArray.length];
        int count = 0;
        List<Integer> result = new ArrayList<>();

        while (count != targetCharArray.length) {
            boolean isModified = false;
            for (int i = 0; i <= targetCharArray.length - stamp.length(); i++) {

                if (!visited[i] && canReplace(i, targetCharArray, stampCharArray)) {
                    count = replace(targetCharArray, stampCharArray, i, count);
                    visited[i] = true;
                    isModified = true;
                    result.add(i);
                    if (count == targetCharArray.length) {
                        break;
                    }

                }
                
                System.out.println(Arrays.toString(targetCharArray));

            }
            if (!isModified) {
                return new int[0];
            }

        }
        
   

        int[] finalResult = new int[result.size()];
        int idx = 0;
        for (int i = result.size() - 1; i >= 0; i--) {
            finalResult[idx++] = result.get(i);
        }

        return finalResult;
    }

    private boolean canReplace(int idx, char[] targetCharArray, char[] stampCharArray) {
        for (int i = 0; i < stampCharArray.length; i++) {
            if (targetCharArray[idx + i] != '?' && targetCharArray[idx + i] != stampCharArray[i]) {
                return false;
            }
        }
        return true;

    }

    private int replace(char[] targetCharArray, char[] stampCharArray, int idx, int count) {
        for (int i = 0; i < stampCharArray.length; i++) {
            if (targetCharArray[i + idx] != '?') {
                targetCharArray[i + idx] = '?';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC936StampingSequence obj = new LC936StampingSequence();
        String stamp = "abca";
        String target = "aabcaca";
        System.out.println(Arrays.toString(obj.movesToStamp(stamp, target)));
    }

}
