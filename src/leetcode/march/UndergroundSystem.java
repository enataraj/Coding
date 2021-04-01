package leetcode.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    private class CustomerData {
        int id;
        String stationName;
        int time;

        public CustomerData(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.time = t;
        }

        public String toString() {
            return "id :" + id + " stationName " + stationName + " time  " + time;
        }
    }

    private class TravelTime {
        String startStation;
        String endStation;
        int travellerCnt;
        int totalTime;

        public TravelTime(String startStation, String endStation, int travellerCnt, int totalTime) {
            this.startStation = startStation;
            this.endStation = endStation;
            this.totalTime = totalTime;
            this.travellerCnt = travellerCnt;
        }

        public String toString() {
            return "start startion : " + startStation + " endStation :" + endStation + " travellerCnt : " + travellerCnt
                    + " total Time " + totalTime;
        }
    }

    Map<Integer, CustomerData> map;
    Map<String, List<TravelTime>> avgMap;

    public UndergroundSystem() {
        map = new HashMap<>();
        avgMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        CustomerData data = new CustomerData(id, stationName, t);
        // System.out.println("Check In  :" + data);
        map.put(id, data);

    }

    public void checkOut(int id, String endStation, int t) {
        //  System.out.println("Check Out : " + id + " endStation :" + endStation + " time t " + t);
        CustomerData data = map.remove(id);
        String startStation = data.stationName;
        int travelTime = t - data.time;

        List<TravelTime> travelDataList = avgMap.get(startStation);
        if (travelDataList != null && !travelDataList.isEmpty()) {
            for (int i = 0; i < travelDataList.size(); i++) {
                TravelTime travelData = travelDataList.get(i);
                if (travelData.endStation.equals(endStation)) {
                    travelData.travellerCnt = travelData.travellerCnt + 1;
                    travelData.totalTime = travelData.totalTime + travelTime;
                    travelDataList.set(i, travelData);
                    avgMap.put(startStation, travelDataList);
                    System.out.println(avgMap);
                    return;
                }

            }
            TravelTime travelData = new TravelTime(startStation, endStation, 1, travelTime);
            travelDataList.add(travelData);
            avgMap.put(startStation, travelDataList);
            return;
        }

        TravelTime travelData = new TravelTime(startStation, endStation, 1, travelTime);
        List<TravelTime> list = new ArrayList<>();
        list.add(travelData);
        avgMap.put(startStation, list);

    }

    public double getAverageTime(String startStation, String endStation) {

        List<TravelTime> travelDataList = avgMap.get(startStation);
        System.out.println(travelDataList);
        if (travelDataList == null || travelDataList.isEmpty()) {
            getAverageTime(endStation, startStation);
        }
        for (int i = 0; i < travelDataList.size(); i++) {
            TravelTime travelData = travelDataList.get(i);
            if (travelData.endStation.equals(endStation)) {
                return ((travelData.totalTime * 1.0) / (travelData.travellerCnt * 1.0));
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        UndergroundSystem obj = new UndergroundSystem();
        obj.checkIn(37043, "K2618O72", 29);
        obj.checkOut(37043, "U1DTINDT", 39);
        System.out.println(obj.getAverageTime("K2618O72", "U1DTINDT"));
        obj.checkIn(779975, "K2618O72", 112);
        obj.checkOut(779975, "CN3K6CYM", 157);
        System.out.println(obj.getAverageTime("K2618O72", "U1DTINDT"));

        obj.checkIn(706901, "K2618O72", 221);
        System.out.println(obj.getAverageTime("K2618O72", "CN3K6CYM"));

        obj.checkIn(18036, "K2618O72", 258);
        System.out.println(obj.getAverageTime("K2618O72", "U1DTINDT"));
        System.out.println(obj.getAverageTime("K2618O72", "CN3K6CYM"));
        obj.checkOut(18036, "U1DTINDT", 293);

    }

}
