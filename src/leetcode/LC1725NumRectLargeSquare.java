package leetcode;

import java.util.TreeMap;

public class LC1725NumRectLargeSquare {

    public int countGoodRectangles(int[][] rectangles) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            int key = Math.min(rectangles[i][0], rectangles[i][1]);
            if (freqMap.containsKey(key)) {
                freqMap.put(key, freqMap.get(key) + 1);
            } else {
                freqMap.put(key, 1);
            }
        }
       
        return freqMap.get(freqMap.lastKey());

    }
    
    public static int countGoodRectanglesSol(int[][] rectangles) {
        int maxlen=0;
        int max=0;
        for (int i=0;i<rectangles.length;i++){
            int minside=Integer.min(rectangles[i][0],rectangles[i][1]);
            if (minside>maxlen){
                maxlen=minside;
                max=1;
            }
            else if (minside==maxlen){
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC1725NumRectLargeSquare obj = new LC1725NumRectLargeSquare();

    }

}
