package leetcode.string;

public class LC1694ReformatPhoneNumber {
    
    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        int n = number.length();
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < n; i++) {
            b.append(number.charAt(i));
            if((i+1)%3 == 0 && (n%3 == 0 || i < n-3) && i < n-1) b.append("-");
            else if(n%3 != 0 && i == n-3) b.append("-");
        }
        return b.toString();
    }
    
    public String reformatNumberSol1(String number) {
        StringBuilder s = new StringBuilder();        
        int cnt = 0;
        
        for (char n : number.toCharArray()) {
            if (Character.isDigit(n)) {
                if (cnt == 3) {
                    cnt = 0;
                    s.append('-');
                }

                s.append(n);
                cnt++;                
            }
        }
        
        if (cnt == 1) {
            s.setCharAt(s.length() - 2, s.charAt(s.length() - 3));
            s.setCharAt(s.length() - 3, '-');
        }
        
        return s.toString();
    }

    public String reformatNumberNW(String number) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                str.append(number.charAt(i));
            }
        }
        if (str.length() <= 3) {
            return str.toString();
        }

        StringBuffer result = new StringBuffer();
        int tmp = 0;
        int i = 0;
        for (i = 0; i < str.length() - 4; i++) {
            if ((i + 1) % 3 == 0) {
                result.append(str.charAt(i));
                result.append('-');
                tmp = i;
            } else {
                result.append(str.charAt(i));
            }
        }

       // System.out.println(result.toString());
        System.out.println(tmp);
        System.out.println(i);
       
        
        if ((i - tmp) == 0 || (i - tmp) == 1 || (i - tmp) == 2) {
            result.append(str.charAt(i));
            result.append(str.charAt(i + 1));
            result.append('-');
            result.append(str.charAt(i + 2));
            result.append(str.charAt(i + 3));

        } else if ((i - tmp) == 3) {
            result.append(str.charAt(i));
            
            result.append('-');
            result.append(str.charAt(i + 1));
            result.append(str.charAt(i + 2));
            result.append(str.charAt(i + 3));

        } 
        return result.toString();
    }

    public static void main(String[] args) {
        LC1694ReformatPhoneNumber obj = new LC1694ReformatPhoneNumber();
        System.out.println(obj.reformatNumber("1-23-45 6"));
        System.out.println(obj.reformatNumber("1-23-45 67"));
        System.out.println(obj.reformatNumber("1-23-45 678"));
        
    }

}
