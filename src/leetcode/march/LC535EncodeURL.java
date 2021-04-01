package leetcode.march;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC535EncodeURL {
    
    Map<String,String> cache = new HashMap<>();
    String keyString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    Random ran = new Random();
    String baseurl = "https://tinyurl.com/";
    
    public String encode(String longUrl) {
        return baseurl+hash(longUrl);
        
        
    }
    
    public String decode(String shortUrl) {
        String[] splitStr = shortUrl.split("/");
        return cache.get(splitStr[splitStr.length-1]);
        
    }
    
    public String hash(String longUrl) {
        // Decided the hash length 6
        StringBuffer hash = new StringBuffer();
        for(int i=0;i<6;i++) {
        int randomInt = ran.nextInt(keyString.length());
        hash.append(keyString.charAt(randomInt));
        }
        
        String hashString = hash.toString();
        if(cache.containsKey(hashString)) {
            return hash(longUrl);
        }
        
        cache.put(hashString,longUrl);
        return hashString;
        
    }
    
 
    private class test {
        
        Map<String, String> urlMap;
        Random r;
        final int BOUND;
        final String TINY_URL_PREFIX;
        
        test() {
            urlMap = new HashMap<>();
            r = new Random();
            BOUND = (int) Math.pow(26, 6);
            TINY_URL_PREFIX = "http://tinyurl.com/";
        }
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            
            String encodedStr;
            do {
                int rand = r.nextInt(BOUND);
                encodedStr = getEncodedString(rand);
                
            } while (urlMap.containsKey(encodedStr));
            
            urlMap.put(encodedStr, longUrl);
            return TINY_URL_PREFIX + encodedStr;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (!shortUrl.startsWith(TINY_URL_PREFIX)) {
                return "Invalid short url";
            }
            
            String encodedSuffix = shortUrl.substring(TINY_URL_PREFIX.length());
            return urlMap.get(encodedSuffix);
        }
        
        private String getEncodedString(int randomNum) {
            StringBuilder sb = new StringBuilder();
            while (randomNum > 0) {
                sb.insert(0, (char) ('a' + randomNum % 26));
                randomNum /= 26;
                
            }
            
            return sb.toString();
        }
    }
}
