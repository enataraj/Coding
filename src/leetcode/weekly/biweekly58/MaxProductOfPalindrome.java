package leetcode.weekly.biweekly58;

public class MaxProductOfPalindrome {
    long result = 1;

    public long maxProduct(String s) {

        for (int i = 1; i < s.length(); i++) {
            int str = longestPalindrome(s.substring(0, i));
            int str1 = longestPalindrome(s.substring(i));
            result = Math.max(str * str1, result);
        }

        return result;

    }

    public int longestPalindrome(String s) {
        int startPos = 0, endPos = 0, i = 0, l = 0 , r = 0;       
        int len = s.length();
           char[] c = s.toCharArray();
           
           while(i < len){
               l = r = i;
              
               while(r + 1 < len && c[i] == c[r+1]) r++;
               i = r+1;
               while(r + 1 < len && l -1 >= 0 && c[l-1] == c[r+1]){
                   r++;
                   l--;
               }
            
               if(r+1-l > endPos+1-startPos){
                   startPos = l;
                   endPos = r;
               }
           }
           return endPos+1-startPos;
       
       }

    
    public static void main(String[] args) {
        MaxProductOfPalindrome obj = new MaxProductOfPalindrome();
        System.out.println(obj.maxProduct("zaaaxbbby"));
    }

}
