package leetcode.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < list.size(); i++) {
            int[] tmp = list.get(i);
            if ((tmp[0] <= start && tmp[1] > start) || (tmp[0] < end && tmp[1] >= end)
                    || (tmp[0] >= start && tmp[1] <= end)) {
                return false;
            }
        }
        list.add(new int[] { start, end });
        return true;

    }

    class MyCalendar1 {
        TreeMap<Integer, Integer> map;

        public MyCalendar1() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {

            Integer fkey = map.floorKey(start);
            Integer ckey = map.ceilingKey(start);

            if ((fkey != null && map.get(fkey) > start) || (ckey != null && ckey < end)) {

                return false;
            }

            map.put(start, end);
            return true;

        }
    }

    public class MyCalendar2 {
        List<int[]> calendar;

        MyCalendar2() {
            calendar = new ArrayList();
        }

        public boolean book(int start, int end) {
            for (int[] iv : calendar) {
                if (iv[0] < end && start < iv[1])
                    return false;
            }
            calendar.add(new int[] { start, end });
            return true;
        }
    }

    class MyCalendar4 {
        TreeMap<Integer, Integer> calendar;

        public MyCalendar4() {
            this.calendar = new TreeMap<Integer, Integer>();
        }

        public boolean book(int start, int end) {
            Entry<Integer, Integer> floorEntry = calendar.floorEntry(start);
            Entry<Integer, Integer> ceilEntry = calendar.ceilingEntry(start);
            if (ceilEntry != null && ceilEntry.getKey() < end)
                return false;
            if (floorEntry != null && floorEntry.getValue() > start)
                return false;
            calendar.put(start, end);
            return true;
        }
    }

    public static void main(String[] args) {

    }

    /*
     * 
     ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
      [[],[47,50],[33,41],[39,45],[33,42],    [25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
     */

    //[null,true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false, true,false,false, false]
    //[null,true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false, false,false,false, true]

    //["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
    //[[],[97,100],[33,51],[89,100],[83,100],[75,92],[76,95],[19,30],[53,63],[8,23],[18,37],[87,100],[83,100],[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15]]

    //[[],[97,100],[33,51],[75,92],[19,30],[53,63] ,

    // [13,32] [2,15]]

}
