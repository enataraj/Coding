package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItenary {

    /*
     * Stack<String> queue = new Stack<>(); queue.add("JFK"); //
     * queue.addAll(itrMap.get("JFK"));
     * 
     * while (!queue.isEmpty()) { String src = queue.pop(); result.add(src);
     * List<String> destList = adjList.remove(src); if (destList != null &&
     * destList.size() > 1) { // queue.add(src); queue.add(destList.get(0));
     * destList.remove(0); adjList.put(src, destList); System.out.println("-->" +
     * adjList);
     * 
     * } else if (destList != null && destList.size() == 1) {
     * queue.add(destList.get(0));
     * 
     * }
     * 
     * System.out.println(queue);
     * 
     * }
     */

    class PlaceData implements Comparable<PlaceData> {
        String place;
        boolean visited = false;

        @Override
        public String toString() {

            return "Place : " + place + " visited : " + visited;
        }

        public int compareTo(PlaceData obj) {
           
            return this.place.compareTo(obj.place);

        };

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return null;
        }

        Map<String, List<PlaceData>> adjList = new HashMap<>();
        List<String> result = new ArrayList<>();
        // Building Adjancy List
        for (int i = 0; i < tickets.size(); i++) {
            List<String> list = tickets.get(i);
            if (adjList.get(list.get(0)) == null) {
                List<PlaceData> destList = new ArrayList<>();
                PlaceData data = new PlaceData();
                data.place = list.get(1);
                destList.add(data);
                adjList.put(list.get(0), destList);
            } else {
                List<PlaceData> destList = adjList.get(list.get(0));
                PlaceData data = new PlaceData();
                data.place = list.get(1);
                destList.add(data);
                adjList.put(list.get(0), destList);

            }

        }

        // Sorting Adj List

        for (String key : adjList.keySet()) {

            List<PlaceData> list = adjList.get(key);
            Collections.sort(list);
            adjList.put(key, list);

        }

      //  System.out.println(adjList);
        dfs("JFK", adjList, result);
        Collections.reverse(result);
        return result;

    }

    void dfs(String from, Map<String, List<PlaceData>> adjList, List<String> result) {
        System.out.println(adjList);
        List<PlaceData> list = adjList.get(from);
        System.out.println("From  " + from);
       // System.out.println(list);
        if (list != null) {
            for (PlaceData placeData : list) {
                if (!placeData.visited) {
                    placeData.visited = true;
                    String to = placeData.place;
                    dfs(to, adjList, result);
                }
            }
          
        }
        result.add(from);
    }

    public static void main(String[] args) {

        // Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        // Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

        /*
         * ArrayList<String> list = new ArrayList<>(); list.add("MUC"); list.add("LHR");
         * 
         * ArrayList<String> list2 = new ArrayList<>(); list2.add("JFK");
         * list2.add("MUC");
         * 
         * ArrayList<String> list3 = new ArrayList<>(); list3.add("SFO");
         * list3.add("SJC"); ArrayList<String> list4 = new ArrayList<>();
         * list4.add("LHR"); list4.add("SFO");
         */

        // Input:
        // [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        // Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
        // Explanation: Another possible reconstruction is
        // ["JFK","SFO","ATL","JFK","ATL","SFO"].
        // But it is larger in lexical order.

        
          ArrayList<String> list = new ArrayList<>(); list.add("JFK"); list.add("SFO");
          
          ArrayList<String> list2 = new ArrayList<>(); list2.add("JFK");
          list2.add("ATL");
          
          ArrayList<String> list3 = new ArrayList<>(); list3.add("SFO");
         list3.add("ATL");
          
          ArrayList<String> list4 = new ArrayList<>(); list4.add("ATL");
          list4.add("JFK");
         
          ArrayList<String> list5 = new ArrayList<>(); list5.add("ATL");
          list5.add("SFO");
          
         

        // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        // ["JFK","NRT","JFK","KUL"]

      /*  ArrayList<String> list = new ArrayList<>();
        list.add("JFK");
        list.add("KUL");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("NRT");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("NRT");
        list3.add("JFK");*/

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(list);
        tickets.add(list2);
        tickets.add(list3);
        tickets.add(list4);
        tickets.add(list5);

        ReconstructItenary obj = new ReconstructItenary();
        List<String> result = obj.findItinerary(tickets);
        System.out.println("Result : " + result);

    }
    
    
   // OptimizedSolition
    public List<String> findItineraryOptimized(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> l : tickets){
            map.putIfAbsent(l.get(0), new PriorityQueue<>());
            map.get(l.get(0)).add(l.get(1));
        }
        helper(res, map, "JFK");
        return res;
    }
    private void helper(List<String> res, Map<String, PriorityQueue<String>> map, String cur){
        PriorityQueue<String> pq = map.get(cur);
        while(pq != null && !pq.isEmpty()){
            helper(res, map, pq.poll());
        }
        res.add(0, cur);
    }

}
