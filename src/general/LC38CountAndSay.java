package general;

public class LC38CountAndSay {

    public String countAndSay(int n) {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("1");

        for (int i = 0; i < n-1; i++) {
            strBuffer = findDuplicateNumberAndCount(strBuffer);

        }

        return strBuffer.toString();
    }

    private StringBuffer findDuplicateNumberAndCount(StringBuffer str) {
        int count = 1;
        StringBuffer resultBuffer = new StringBuffer();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                resultBuffer.append(count);
                resultBuffer.append(str.charAt(i - 1));
                count = 1;
            }
        }
        resultBuffer.append(count);
        resultBuffer.append(str.charAt(str.length() - 1));
        return resultBuffer;
    }
    
    public String countAndSaySol(int n) {
        if(n==1){
            return "1";
        }
        StringBuilder result = new StringBuilder();
        String prev = countAndSay(n-1);
        for(int i=0;i<prev.length();){
            int count = 0;
            char c = prev.charAt(i);
            while(i<prev.length() && c==prev.charAt(i)){
                count++;
                i++;
            }
            result.append(count);
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        LC38CountAndSay obj = new LC38CountAndSay();
        int n = 3;
        System.out.println(obj.countAndSay(n));
       // obj.findDuplicateNumberAndCount("1");

    }

}
