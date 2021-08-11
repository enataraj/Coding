package leetcode.weekly.biweekly58;

public class FancyString {
    public String makeFancyString(String s) {
        char[] chArray = s.toCharArray();
        int cnt=0;
        char curCh = chArray[0];
        for(int i=1;i<chArray.length;i++){
            if(curCh==chArray[i]){
                cnt++;
                if(cnt>=2){
                   chArray[i] ='#'; 
                }
            }else{
                cnt=0;
                curCh = chArray[i];
            }
        }
        StringBuffer buf = new StringBuffer();
         for(int i=0;i<chArray.length;i++){
             if(chArray[i]!='#'){
                buf.append(chArray[i]);
             }
         }
        return buf.toString();
    }
    public static void main(String[] args) {
        FancyString obj = new FancyString();
        System.out.println(obj.makeFancyString("aaabaaaa"));
    }

}
