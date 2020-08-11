package leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WorkBreakMine {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        Map<String, List<String>> cache = new HashMap<>();
        Set<String> impossibles = new HashSet<>();
        return helper(s, dict, cache, impossibles);
    }
    
    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> cache, Set<String> impossibles) {
        if (s.isEmpty()) {
            return Arrays.asList("");
            
        } else if (impossibles.contains(s)) {
            return Collections.emptyList();
            
        } else if (cache.containsKey(s)) {
            return cache.get(s);
            
        }
        
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {
                List<String> res2 = helper(s.substring(i), dict, cache, impossibles);
                for (String p : res2) {
                    res.add((sub + " " + p).trim());
                }
            }
        }
        
        if (!res.isEmpty()) {
            cache.put(s, res);
        } else {
            impossibles.add(s);
        }
        
        return res;
    }
    

}
