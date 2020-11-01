package leetcode.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        
        
        if(null == s || s.isEmpty()) return new ArrayList<>();
        Set<String> seqList = new HashSet<>();
        Set<String> list = new HashSet<>();
        for(int i = 0; i< s.length()-9; i++) {
            String seq = s.substring(i, i+10);
            if(!seqList.add(seq)) 
                list.add(seq);
        }
        return new ArrayList<>(list);
        
      
    }

    
    private int PRIME = 17;
    public List<String> findRepeatedDnaSequencesNW(String s) {
        List<String> list = new ArrayList();
        Long hash = 0L;
        char[] cha = s.toCharArray();
        if (cha.length <=10) return list; 
        for (int i=0; i<10; i++){
            int val = getVal(cha[i]);
            hash = hash + (long)(val * Math.pow(PRIME, i));
        }
        Map<Long, Integer> hm = new HashMap();
        hm.put(hash, 0);
        Set<String> set = new HashSet();
        for (int i = 1; i<=cha.length-10; i++){
            int pnum = getVal(cha[i-1]);
            int nnum = getVal(cha[i+9]);
            hash = ((hash - pnum) / PRIME) + (long)(nnum * Math.pow(PRIME, 9));
            if(hm.containsKey(hash) ){
                String newStr = s.substring(i, i+10);
                set.add(newStr);    
            } else {
                hm.put(hash, i);
            }
        }
        return set.stream().collect(Collectors.toList());    
    }
    private int getVal(char ch){
        if (ch == 'A') return 1;
        else if(ch == 'C') return 2;
        else if(ch == 'G') return 3;
        else return 4;
    }
    
    public static void main(String[] args) {
        RepeatedDNASequence obj = new RepeatedDNASequence();
        String s = "AAAAAAAAAAAAAAABBBB";
        System.out.println(obj.findRepeatedDnaSequences(s));
    }
}
