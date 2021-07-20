package leetcode.string;

public class LC796RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }
        StringBuffer goalBuffer = new StringBuffer(goal);
        StringBuffer sBuffer = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = goalBuffer.charAt(0);
            goalBuffer.deleteCharAt(0);
            goalBuffer.append(ch);
            if (s.equals(goalBuffer.toString())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean rotateStringAlt(String s, String goal) {
        
        if(goal.length() < s.length()){
            return false;
        }
         
         String newstr = s+s;
         
         if(newstr.contains(goal)){
             return true;
         }
         
         return false;
     }
public static void main(String[] args) {
    String s = "abcde";
    String goal = "cdeab";
    LC796RotateString obj = new LC796RotateString();
            
    System.out.println(obj.rotateString(s, goal));
}
}
