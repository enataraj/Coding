package leetcode.sep2021;

import java.util.ArrayList;
import java.util.List;

public class LC401BinarySearch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> resultList = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                int hourCnt = Integer.bitCount(hour);
                int minCnt = Integer.bitCount(min);
                if ((hourCnt + minCnt) <= turnedOn) {

                    String minStr;
                    if (min < 9) {
                        minStr = "0" + min;
                    } else {
                        minStr = "" + min;
                    }

                    resultList.add(hour + minStr);
                }
            }
        }
        return resultList;
    }

}
