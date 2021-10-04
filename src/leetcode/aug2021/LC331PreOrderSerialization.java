package leetcode.aug2021;

import java.util.Stack;

public class LC331PreOrderSerialization {
    boolean result = true;

    public boolean isValidSerialization(String preorder) {
        String[] preOrderStringArray = preorder.split(",");
        int numPossibleChildren = 1;
        for (String nodeVal : preOrderStringArray) {
            numPossibleChildren -= 1;
            if (numPossibleChildren < 0) {
                return false;
            }
            if (!nodeVal.equals("#")) {
                numPossibleChildren += 2;
            }
        }
        return numPossibleChildren == 0;
    }

    public boolean isValidSerializationStack(String preorder) {
        // case 1: number just push 
        // case 2: '#'
        //         case 1: stack top is '#' ,pop two elements, then push '#' to the stack 
        //         case 2: other cases just push '#'
        //At last check the state of the stack
        Stack<String> st = new Stack<String>();
        for (String t : preorder.split(",")) {
            if (t.equals("#")) {
                while (!st.isEmpty() && st.peek().equals("#")) {
                    st.pop();
                    if (st.isEmpty())
                        return false;
                    st.pop();
                }
                st.push(t);
            } else {
                st.push(t);
            }
        }

        return st.size() == 1 && st.peek().equals("#");
    }

    public static void main(String[] args) {
        LC331PreOrderSerialization obj = new LC331PreOrderSerialization();
        String preorder = "1,#,2";
        System.out.println(obj.isValidSerialization(preorder));
    }
}
