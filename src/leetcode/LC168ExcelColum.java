package leetcode;

public class LC168ExcelColum {

    public String convertToTitle(int n) { char[] columnName = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X','Y', 'Z' };
    StringBuffer result = new StringBuffer();
    int mod;
    if(n<=26){
         result.append(columnName[n-1]);
         return result.toString();
    }

    while (n > 0) {
        n--;
        mod = n % 26;
        result.append(columnName[mod]);
        n = n / 26;

    }

    return result.reverse().toString();
}

    public static void main(String[] args) {
        LC168ExcelColum obj = new LC168ExcelColum();
        int n = 28;
        System.out.println(obj.convertToTitle(n));
    }

}
