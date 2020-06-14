package general;

public class ReverseStringRecursion {
    
    private static void reverse(String str , int len) {
        if(len<0) {
            return;
        }
        System.out.print(str.charAt(len));   
        reverse(str,len-1);
        
    }
    
    public static void main(String[] args) {
        String str = "Elumalai";
        reverse(str,str.length()-1);
    }

}
