package leetcode.july;

public class BinaryAddition {

    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty())
            return b;
        if (b == null || b.isEmpty())
            return a;
        StringBuilder strBuild = new StringBuilder();

        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        char carry = '0';

        while (aLen != -1 && bLen != -1) {
            if (a.charAt(aLen) == '1' && b.charAt(bLen) == '1') {
                if (carry == '1') {
                    strBuild.append('1');
                } else {
                    strBuild.append('0');
                }
                carry = '1';

            } else if (a.charAt(aLen) == '0' && b.charAt(bLen) == '0') {
                if (carry == '1') {
                    strBuild.append('1');
                } else {
                    strBuild.append('0');
                }
                carry = '0';

            } else if (carry == '1') {
                carry = '1';
                strBuild.append('0');
            } else {
                carry = '0';
                strBuild.append('1');
            }
            aLen--;
            bLen--;
        }

        while (aLen != -1) {
            if (carry == '1') {
                if (a.charAt(aLen) == '1') {
                    carry = '1';
                    strBuild.append('0');
                } else {
                    carry = '0';
                    strBuild.append('1');
                }

            } else {
                strBuild.append(a.charAt(aLen));
            }
            aLen--;
        }

        while (bLen != -1) {
            if (carry == '1') {
                if (b.charAt(bLen) == '1') {
                    carry = '1';
                    strBuild.append('0');
                } else {
                    carry = '0';
                    strBuild.append('1');
                }

            } else {
                strBuild.append(b.charAt(bLen));
            }
            bLen--;
        }

        if (carry == '1') {
            strBuild.append('1');
        }

        return new String(strBuild.reverse());

    }
    
    
    
    
    
public String addBinaryOpt(String a, String b) {
        
        int m = a.length();
        int n = b.length();
        
        if(m < 1 || n < 1)
            return null;
        
        if(m < n)
            return addBinary(b, a);
        
        int carry = 0;
        int j = n - 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = m - 1; i >= 0; i--) {
            if(a.charAt(i) == '1')
                carry++;
            if(j > -1 && b.charAt(j--) == '1')
                carry++;
            
            if(carry % 2 == 1)
                sb.append("1");
            else
                sb.append("0");
            
            carry /= 2;
        }
        
        if(carry == 1)
            sb.append("1");
        
        sb.reverse();
        
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryAddition obj = new BinaryAddition();
        String a = "110";
        String b = "11";
        String res = obj.addBinary(a, b);
        System.out.println(res);

    }

}
