package leetcode;

import java.util.Stack;

public class LC1323MaxNumber69 {

    public int maximum69Number(int num) {
        Stack<Integer> numStack = new Stack();
        while (num > 0) {
            numStack.push(num % 10);
            num = num / 10;
        }
       
        boolean flag = true;
        while (!numStack.isEmpty()) {
            if (numStack.peek() == 6 && flag) {
                num = num * 10 + 9;
                flag = false;
                numStack.pop();
            } else {
                num = num * 10 + numStack.pop();
            }
        }

        return num;

    }
    
    public int maximum69NumberSol(int num) {
        int dup = num, pow = -1, digits = 0;
        while (dup != 0) {
            if (dup % 10 == 6)
                pow = digits;
            dup /= 10;
            digits++;
        }
        return num + (pow == -1 ? 0 : 3 * (int) Math.pow(10, pow));
    }

    public static void main(String[] args) {
        LC1323MaxNumber69 obj = new LC1323MaxNumber69();
        int num = 9669;
        System.out.println(obj.maximum69Number(num));

    }

}
