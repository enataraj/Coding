package general;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TopVotedCandidate {

    private int[] persons;
    private int[] times;
    private Map<Integer, Map<Integer, Integer>> votes = new TreeMap<>();
    private Map<Integer, Integer> personVoteMap = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        buildVotesCounting();
    }

    private void buildVotesCounting() {
        personVoteMap = new HashMap<>();
        personVoteMap.put(persons[0], 1);
        votes.put(times[0], personVoteMap);

        for (int i = 1; i < times.length; i++) {
            Map<Integer, Integer> newMap = new HashMap<>(personVoteMap);
            if (newMap.containsKey(persons[i])) {
                newMap.put(persons[i], newMap.get(persons[i]) + 1);
            } else {

                newMap.put(persons[i], 1);
            }
            votes.put(times[i], newMap);
        }
        
    }

    public int q(int t) {
       
        int resKey = -1;
        for(int key:votes.keySet()) {
            if(key<=t) {
                resKey = key;
            }
        }
        
        Map<Integer,Integer> values = votes.get(resKey);
        
        int result=Integer.MIN_VALUE;
        int vote = Integer.MIN_VALUE;
        for(int key:values.keySet()) {
            if(vote<values.get(key)) {
                result = key;
            }
        }
        
        return result;

    }

    public static void main(String[] args) {
        int[] persons = { 0, 1, 1, 0, 0, 1, 0 };
        int[] times = { 0, 5, 10, 15, 20, 25, 30 };
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);
        System.out.println(obj.q(3));
        System.out.println(obj.q(12));
        System.out.println(obj.q(25));

    }

}
