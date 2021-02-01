package leetcode;

public class LC1370IncreasingDecresing {

    public String sortString(String s) {

        int[] charMap = new int[26];
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };
        StringBuffer strBuffer = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 97] = charMap[s.charAt(i) - 97] + 1;

        }

        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (charMap[i] != 0) {
                    charMap[i] = charMap[i] - 1;
                    strBuffer.append(chars[i]);
                    count++;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (charMap[i] != 0) {
                    charMap[i] = charMap[i] - 1;
                    strBuffer.append(chars[i]);
                    count++;
                }
            }
           
        }

        return strBuffer.toString();

    }
    
    
    public String sortStringSol(String s) {
        int[] dic = new int[26];
        for(char ch:s.toCharArray()) 
            dic[ch-'a']++;
        StringBuilder sb = new StringBuilder();
        boolean reverse = false;
        while(sb.length()<s.length()){
            sort(dic,sb,reverse);
            reverse = !reverse;
        }
        return sb.toString();
    }
    
    private void sort(int[] dic, StringBuilder sb, boolean reverse){
        for(int i=0;i<26;i++){
            int j = reverse? 25-i:i;
            if(dic[j]>0){
                dic[j]--;
                sb.append((char)(j+'a') );
            }
        }
    }
    


    public static void main(String[] args) {
        LC1370IncreasingDecresing obj = new LC1370IncreasingDecresing();
        String s = "aaaabbbbcccc";
        System.out.println(obj.sortString(s));

    }

}
