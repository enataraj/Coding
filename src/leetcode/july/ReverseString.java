package leetcode.july;

public class ReverseString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;

        while (i <= j) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
            i++;
            j--;

        }

        System.out.println(new String(charArray));

        int beginIdx = 0;
        int endInx = 0;
        for (i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ' || i == charArray.length - 1) {
                endInx = i - 1;
                while (beginIdx <= endInx) {
                    char tmp = charArray[beginIdx];
                    charArray[beginIdx] = charArray[endInx];
                    charArray[endInx] = tmp;
                    beginIdx++;
                    endInx--;

                }
                beginIdx = i + 1;

            }
            
            if (i == charArray.length - 1) {
                endInx = i;
                while (beginIdx <= endInx) {
                    char tmp = charArray[beginIdx];
                    charArray[beginIdx] = charArray[endInx];
                    charArray[endInx] = tmp;
                    beginIdx++;
                    endInx--;

                }
               
            }

        }
        return new String(charArray);
    }
    
    
    private void reverse(char[] charArray,int beginIdx,int endInx) {
        while (beginIdx <= endInx) {
            char tmp = charArray[beginIdx];
            charArray[beginIdx] = charArray[endInx];
            charArray[endInx] = tmp;
            beginIdx++;
            endInx--;

        }
        
    }
    
    public String reverseWords_optimized(String s) {
        String[] str = s.split(" ");
        StringBuffer sBuff = new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            if(!str[i].isEmpty()){
              sBuff= sBuff.append(str[i]);
                if(i!=0){
                    sBuff.append(" ");
                }  
            }
 
        }
        return sBuff.toString().trim();
    }

    public static void main(String[] args) {

        String s = "ate good   example";
        ReverseString obj = new ReverseString();
        System.out.println(s.length());
        s = obj.reverseWords(s);
        System.out.println(s);
        System.out.println(s.length());

    }

}
