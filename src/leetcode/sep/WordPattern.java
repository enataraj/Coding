package leetcode.sep;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
			return false;
		}

		String[] strArray = str.split(" ");
		if (pattern.length() != strArray.length) {
			return false;
		}

		Map<String, Character> strMap = new HashMap<>();
		Map<Character, String> patternMap = new HashMap<>();
		for (int i = 0; i < strArray.length; i++) {
			String tmpStr = strArray[i].trim();
			char ch = pattern.charAt(i);
			if (strMap.containsKey(tmpStr)) {
				char patChar = strMap.get(tmpStr);
				if (patChar != ch) {
					return false;
				}
			} else if (patternMap.containsKey(ch)) {
				String patStr = patternMap.get(ch);
				if (!patStr.equals(strArray[i].trim())) {
					return false;
				}
			} else {
				strMap.put(tmpStr, ch);
				patternMap.put(ch, tmpStr);
			}

		}

		return true;

	}
	
	public boolean wordPatternOpt(String pattern, String str) {    
	      
        String[] strArr= str.split(" ");
        if(pattern.length()!=strArr.length){
            return false;
        }
        
         HashMap h1= new HashMap();
        int i=0;
        
        while(i<pattern.length()){
           String mama= strArr[i];
            char dai= pattern.charAt(i);
                
          if(!h1.containsKey(dai)){
              h1.put(dai,mama);
          }
            if(!h1.containsKey(mama)){
                 h1.put(mama,dai);
            }
            
            if(!h1.get(dai).equals(mama) || !h1.get(mama).equals(dai)){
                return false;
            }
            
             
            i++;
        }
        
        return true;
    }
	
	public boolean wordPatternoopt(String pattern, String str) {
		String[] split = str.split(" ");
		if (pattern.length() != split.length)
			return false;
		Map<Character, String> map = new HashMap<Character, String>();
		for (int index = 0; index < pattern.length(); index++) {
			char currentChar = pattern.charAt(index);
			String currentStr = split[index];
			if (map.containsKey(currentChar) || map.containsValue(currentStr)) {
				if (!map.containsKey(currentChar) || !map.get(currentChar).equals(currentStr))
					return false;
			}
			map.put(currentChar, currentStr);
		}
		return true;
	}

	public static void main(String[] args) {

		WordPattern obj = new WordPattern();
		String pattern = "abba";
		String str = "cat dog dog dog";
		System.out.println(obj.wordPattern(pattern, str));

	}

}
