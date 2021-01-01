package leetcode;

public class LC1021RemoveOuterMostParen {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        char[] str = S.toCharArray();
        StringBuffer strBuffer = new StringBuffer();
        int count = 0;
        int start = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (count == 0) {
                start = i;
            }
            if (ch == '(') {

                count++;
            }
            if (ch == ')') {
                count--;
            }
            if (count == 0) {
                str[start] = '#';
                str[i] = '#';

            }

        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '#') {
                strBuffer.append(S.charAt(i));
            }
        }

        return strBuffer.toString();

    }
    
    public String removeOuterParenthesesSol(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : S.toCharArray()){
            if(ch == '('){
                count++;
                if(count > 1){
                    sb.append(ch);
                }
            }
            else{
                count--;
                if(count>0){
                    sb.append(ch);
                }
            }
        }    
        return sb.toString();
    }

    public static void main(String[] args) {
        LC1021RemoveOuterMostParen obj = new LC1021RemoveOuterMostParen();
        String S = "(()())(())(()(()))";
        System.out.println(obj.removeOuterParentheses(S));

    }

}
