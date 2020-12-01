package leetcode.nov;

import java.util.Stack;

public class BasicCalculator2 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<String> numStack = new Stack<>();
        StringBuffer str = new StringBuffer();
       
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '\0') {
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                str.append(s.charAt(i));

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                String curOper = s.charAt(i) + "";
                helpher(numStack, curOper, str.toString());
                str = new StringBuffer();

            }
            if (i == s.length() - 1) {
                helpher(numStack, null, str.toString());
            }
            i++;
        }

       
    // Calculation for + or -
        int num1 = Integer.parseInt(numStack.get(0));
        for (i = 1; i < numStack.size(); i++) {
            String oper = numStack.get(i);
            if (oper.equals("+") || oper.equals("-")) {
                int num2 = Integer.parseInt(numStack.get(i + 1));
                if (oper.equals("+")) {
                    num1 = num1 + num2;
                } else if (oper.equals("-")) {
                    num1 = num1 - num2;
                }
            }

        }

        return num1;
    }

    // Calculation for * and / and push it back to Stack
    private void helpher(Stack<String> numStack, String curOper, String curNum) {
        int currentNum = Integer.parseInt(curNum);
        if (!numStack.isEmpty()) {
            String operator = numStack.peek();
            if (operator.equals("*") || operator.equals("/")) {
                operator = numStack.pop();
                int preNum = Integer.parseInt(numStack.pop());
                if (operator.equals("*")) {
                    numStack.push((currentNum * preNum) + "");

                } else if (operator.equals("/")) {
                    numStack.push((preNum / currentNum) + "");
                }
                if (curOper != null) {
                    numStack.push(curOper);
                }
            } else {
                numStack.push(curNum);
                if (curOper != null) {
                    numStack.push(curOper);
                }
            }

        } else {
            numStack.push(curNum);
            if (curOper != null) {
                numStack.push(curOper);
            }
        }

    }

   
    
    public int calculateOpt(String s) {
        int ans = 0;
        int num = 0;
        boolean plus = true;
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            if (c[i] >= '0' && c[i] <= '9') {
                num = 0;
                while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                    num *= 10;
                    num += c[i] - '0';
                    i ++;
                }
                i --;
            } else if (c[i] == '+' || c[i] == '-') {
                if (plus) {
                    ans += num;
                } else {
                    ans -= num;
                }
                plus = c[i] == '+';
            } else if (c[i] == '*' || c[i] == '/') {
                boolean times = true;
                while (i < c.length && c[i] != '+' && c[i] != '-') {
                    if (c[i] == '*') {
                        times = true;
                    } else if (c[i] == '/') {
                        times = false;
                    } else if (c[i] >= '0' && c[i] <= '9') {
                        int number = 0;
                        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                            number *= 10;
                            number += c[i] - '0';
                            i ++;
                        }
                        i --;
                        if (times) {
                            num *= number;
                        } else {
                            num /= number;
                        }
                    }
                    i ++;
                }
                i --;
            }
            i ++;
            if (i == c.length) {
                if (plus) {
                    ans += num;
                } else {
                    ans -= num;
                }
            }
        }
        return ans;
    }

    
    public int calculateStack(String s) {
        s = s.trim();
        
        Stack<Integer> stack = new Stack<>();
        
        char[] c = s.toCharArray();
        int i = 0;
        int l = c.length;
        
        int currentNumber = 0;
        char currentOp = '+';
        while(i < l){
            if(c[i] >= '0' && c[i] <= '9'){
                currentNumber = 0;
                while(i<l && c[i] >= '0' && c[i] <= '9'){
                    currentNumber = currentNumber*10 + (c[i]-'0');
                    i++;
                }
                if(currentOp == '-'){
                    stack.push(-1*currentNumber);
                }else if(currentOp == '+'){
                    stack.push(currentNumber);
                }else if(currentOp == '*'){
                    int last = stack.pop();
                    stack.push(last*currentNumber);
                }else if(currentOp == '/'){
                    int last = stack.pop();
                    stack.push(last/currentNumber);
                }
                i--;
            }else if(c[i] == '-' || c[i] == '+' || c[i] == '*' || c[i] == '/'){
                currentOp = c[i];
            }
            i++;
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        return result;
        
    }

    public static void main(String[] args) {
        BasicCalculator2 obj = new BasicCalculator2();
        String s = " 3/2 ";
        System.out.println(obj.calculate(s));

    }

}
